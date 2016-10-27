from sklearn.externals import joblib
import DBAccess as db_connect
import Messages as msg
import numpy as np

mysql_cn = db_connect.DBConnect()

# Read in the data.
msg.loading_message()
df_mysql = mysql_cn.read('select * from employeesit_raw_predict')
col_names = df_mysql.columns.tolist()

# Don't need these columns
to_drop = ['Employee_ID', 'Employee_Name', 'Reason_To_Leave']
churn_columns = df_mysql.drop(to_drop, axis=1)

# Pull out features for future use
features = churn_columns.columns

mysql_cn.delete('TRUNCATE TABLE feature_importance_churn')

print("Calculating Random Forest Feature Importance..")
clf_churn = joblib.load('D:\SLIIT\SoftwareIndustry\df_model.pkl')
importances_churn=clf_churn.feature_importances_
clf_reason = joblib.load('D:\SLIIT\ITIndustry\Reason\df_model_reason.pkl')
importances_reason=clf_reason.feature_importances_
for num in range(0,len(features)):
    mysql_cn.insert_update("INSERT INTO `feature_importance_churn`(`Feature`, `Importance_Churn`, `Importance_Reason`) VALUES('%s',%s,%s)" % (features[num], round(importances_churn[num]*100,2), round(importances_reason[num]*100,2)))

msg.completed_message()