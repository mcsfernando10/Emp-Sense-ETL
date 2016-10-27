import pandas
import numpy as np
from sklearn.ensemble import RandomForestClassifier as RF
import Tune_Params as tune
import DBAccess as db_connect
import Messages as msg
from sklearn.externals import joblib
from sklearn.metrics import mean_squared_error
import pickle

mysql_cn = db_connect.DBConnect()
#mysql_cn.insert_update("UPDATE tune_user_selection SET is_tune_needed = 0")
tune_params = tune.TuneParams()

# Read in the data.
msg.loading_message()
df_mysql = mysql_cn.read('select * from employeesit_raw_train_temp')
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

from sklearn.cross_validation import KFold


def cv_predict(X,y,clf_class,**kwargs):
    # Construct a kfolds object
    kf = KFold(len(y),n_folds=10,shuffle=True)
    y_pred = y.copy()

    # Iterate through folds
    for train_index, test_index in kf:
        X_train, X_test = X[train_index], X[test_index]
        y_train = y[train_index]
        # Initialize a classifier with key word arguments
        clf = clf_class(**kwargs)
        clf.fit(X_train,y_train)
        y_pred[test_index] = clf.predict(X_test)
    return y_pred

msg.print_line()
msg.calculate_probs_message()
n_estimators, max_features, min_samples_leaf = tune_params.tune_rf(X, y)
y_pred_rf = cv_predict(X, y, RF, n_estimators=n_estimators, max_features=max_features, min_samples_leaf=min_samples_leaf)

#joblib.dump(clf, 'D:\SLIIT\SoftwareIndustry\df_model.pkl', compress=1)

def accuracy(y_true,y_pred):
    return mean_squared_error(y_true, y_pred)

msg.print_line()
msg.mse_message()

print("Random Forest (MSE):")
mse_rf = round(accuracy(y, y_pred_rf), 3)
print(mse_rf)
print()

msg.completed_message()