from sklearn.externals import joblib
from sklearn.neighbors import KNeighborsClassifier
import DBAccess as db_connect
import Messages as msg
import numpy as np
import pandas
import sys

mysql_cn = db_connect.DBConnect()

# Read in the data.
msg.loading_message()
df_mysql = mysql_cn.read('select * from employeesit_raw_predict')
col_names = df_mysql.columns.tolist()

# Isolate target data
# churn_result = df_mysql['churn']
# y = churn_result

# Don't need these columns
to_drop = ['Employee_ID', 'Employee_Name', 'Reason_To_Leave']
churn_columns = df_mysql.drop(to_drop, axis=1)

# Pull out features for future use
features = churn_columns.columns

X = churn_columns.as_matrix().astype(np.float)

# Standardizing the features so that they are
# centered around 0 with a standard deviation of 1
from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()
X = scaler.fit_transform(X)

algo_id = sys.argv[1:]
if int(algo_id[0]) == 1:
    print("K-Nearest-Neighbors")
    clf = joblib.load('D:\SLIIT\ITIndustry\Reason\knn_model_reason.pkl')
    pred_reason = clf.predict(X)
elif int(algo_id[0]) == 2:
    print("Random Forest")
    clf = joblib.load('D:\SLIIT\ITIndustry\Reason\df_model_reason.pkl')
    pred_reason = clf.predict(X)
else:
    print("Support Vector Machine")
    clf = joblib.load('D:\SLIIT\ITIndustry\Reason\svm_model_reason.pkl')
    pred_reason = clf.predict(X)

data_id = mysql_cn.read('select * from employeesit_predict')
emp_id = data_id['Employee_ID']
id = emp_id.tolist()

pred_reason.tolist()

msg.update_message()
for num in range(0,len(id)):
    mysql_cn.insert_update("UPDATE employeesit_predict SET Reason_To_Leave = (SELECT reason FROM reasonuniques WHERE id = %s) WHERE Employee_ID='%s'" %
                       (pred_reason[num], id[num]))
					   
msg.completed_message()