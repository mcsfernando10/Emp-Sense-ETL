import os
from sklearn.externals import joblib
import Tune_Params as tune
import DBAccess as db_connect
import Messages as msg
import numpy as np
import pandas

mysql_cn = db_connect.DBConnect()

mysql_cn.insert_update("UPDATE tune_user_selection SET is_tune_needed = 0")
tune_params = tune.TuneParams()

max_accuracy = mysql_cn.read("SELECT algo_id as 'id' FROM accuracy_confusion_mse WHERE confusion_accuracy = "
                             "(SELECT MAX(confusion_accuracy) FROM accuracy_confusion_mse)")
id = max_accuracy['id'].tolist()

# Read in the data.
msg.loading_message()
df_mysql = mysql_cn.read('select * from employeesit_raw_predict')
col_names = df_mysql.columns.tolist()

# Isolate target data
# churn_result = df_mysql['churn']
# y = churn_result

# Don't need these columns
to_drop = ['Employee_ID', 'Employee_Name',  'WorkFrom', 'WorkTo']
churn_columns = df_mysql.drop(to_drop, axis=1)

# Pull out features for future use
features = churn_columns.columns

X = churn_columns.as_matrix().astype(np.float)

# Standardizing the features so that they are
# centered around 0 with a standard deviation of 1
from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()
X = scaler.fit_transform(X)

if id[0] == 1:
    clf = joblib.load('D:\SLIIT\SoftwareIndustry\knn_model.pkl')
    pred_prob = clf.predict_proba(X)
    pred_churn = pred_prob[:, 1]
elif id[0] == 2:
    clf = joblib.load('D:\SLIIT\SoftwareIndustry\df_model.pkl')
    pred_prob = clf.predict_proba(X)
    pred_churn = pred_prob[:, 1]
else:
    clf = joblib.load('D:\SLIIT\SoftwareIndustry\svm_model.pkl')
    pred_prob = clf.predict_proba(X)
    pred_churn = pred_prob[:, 1]

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

emp_id = df_mysql['Employee_ID']
id = emp_id.tolist()

probability = np.ndarray.round(pred_churn, 2)
probability.tolist()

msg.update_message()
for num in range(0,len(id)):
    mysql_cn.insert_update("UPDATE employeesit_predict SET probability=%s WHERE Employee_ID='%s'" %
                       (probability[num], id[num]))

msg.completed_message()