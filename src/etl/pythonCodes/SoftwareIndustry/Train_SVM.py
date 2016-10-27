import pandas
import numpy as np
from sklearn.svm import SVC
import Tune_Params as tune
import DBAccess as db_connect
import Messages as msg
from sklearn.externals import joblib

mysql_cn = db_connect.DBConnect()
mysql_cn.insert_update("UPDATE tune_user_selection SET is_tune_needed = 0")
tune_params = tune.TuneParams()

# Read in the data.
msg.loading_message()
df_mysql = mysql_cn.read('select * from employeesit_raw_train')
col_names = df_mysql.columns.tolist()

# Isolate target data
churn_result = df_mysql['churn']
y = churn_result

# Don't need these columns
to_drop = ['Employee_ID', 'Employee_Name', 'Reason_To_Leave', 'churn']
churn_columns = df_mysql.drop(to_drop, axis=1)

# Pull out features for future use
features = churn_columns.columns

X = churn_columns.as_matrix().astype(np.float)

# Standardizing the features so that they are
# centered around 0 with a standard deviation of 1
from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()
X = scaler.fit_transform(X)

# ker, c, gamma = tune_params.tune_svm(X,y)
# print(ker, c, gamma)
kernel, c, gamma = tune_params.tune_svm(X,y)

from sklearn.cross_validation import KFold, cross_val_score


def cv_predict(X, y, clf_class, **kwargs):
    # Construct a kfolds object
    kf = KFold(len(y), n_folds=10, shuffle=True)
    y_prob = np.zeros((len(y), 2))
    # Iterate through folds
    for train_index, test_index in kf:
        X_train, X_test = X[train_index], X[test_index]
        y_train = y[train_index]
        # Initialize a classifier with key word arguments
        clf = clf_class(**kwargs)
        clf.fit(X_train, y_train)
        y_prob[test_index] = clf.predict_proba(X_test)
    return y_prob, clf

# svm_scores = cross_val_score(SVC(), X, y, cv=10, scoring='mean_squared_error')
# print("SVM MSE:")
# print(-svm_scores.mean())

msg.print_line()
msg.calculate_probs_message()
pred_prob, clf = cv_predict(X, y, SVC, kernel=kernel, C=c, gamma=gamma, probability=True)
pred_churn = pred_prob[:, 1]

joblib.dump(clf, 'D:\SLIIT\SoftwareIndustry\svm_model.pkl', compress=1)

# Number of times a predicted probability is assigned to an observation
counts = pandas.value_counts(np.ndarray.round(pred_churn, 2))
counts = pandas.concat([counts], axis=1).reset_index()

counts.columns = ['pred_prob', 'count']
print(counts)

df1 = pandas.DataFrame(counts).sort_values(by='pred_prob')
counts_list = df1.values.tolist()

mysql_cn.delete("DELETE FROM prob_counts")

for row in range(0, len(counts_list)):
    x = counts_list[row]
    mysql_cn.insert_update("INSERT INTO prob_counts(probability, emp_count) VALUES(%s, %d)" % (x[0], x[1]))

data_id = mysql_cn.read('select * from employeesit_train')
emp_id = data_id['Employee_ID']
id = emp_id.tolist()

probability = np.ndarray.round(pred_churn, 2)
probability.tolist()

msg.update_message()
for num in range(0,len(id)):
    mysql_cn.insert_update("UPDATE employeesit_train SET probability=%s WHERE Employee_ID='%s'" %
                       (probability[num], id[num]))

msg.completed_message()