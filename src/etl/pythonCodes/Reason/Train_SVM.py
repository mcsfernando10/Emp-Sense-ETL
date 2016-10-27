import pandas
import numpy as np
from sklearn.svm import SVC
import DBAccess as db_connect
import Messages as msg
from sklearn.externals import joblib
from sklearn.cross_validation import train_test_split

mysql_cn = db_connect.DBConnect()

# Read in the data.
msg.loading_message()
df_mysql = mysql_cn.read('select * from employeesit_raw_train where churn = 1;')
col_names = df_mysql.columns.tolist()

# Isolate target data
churn_result_reason = df_mysql['Reason_To_Leave']
y_reason = churn_result_reason

# Don't need these columns
to_drop_reason = ['Employee_ID', 'Employee_Name', 'Reason_To_Leave', 'churn']
reason_colummns = df_mysql.drop(to_drop_reason, axis=1)


# Pull out features for future use
features_reason = reason_colummns.columns

X_reason = reason_colummns.as_matrix().astype(np.float)

# Standardizing the features so that they are
# centered around 0 with a standard deviation of 1
from sklearn.preprocessing import StandardScaler
scaler = StandardScaler()
X_reason = scaler.fit_transform(X_reason)
print('X_reason: ',X_reason.shape)

from sklearn.cross_validation import KFold

def reason_predict(X,y,clf_class,**kwargs):
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.4)
    clf = clf_class(**kwargs)
    clf.fit(X_train, y_train)
    reason = clf.predict(X_test)
    return reason, y_test, clf

msg.print_line()
msg.calculate_probs_message()

y_pred_reason_svm, y_test_svm, clf = reason_predict(X_reason,y_reason, SVC)

joblib.dump(clf, 'D:\SLIIT\ITIndustry\Reason\svm_model_reason.pkl', compress=1)

emp_id = df_mysql['Employee_ID']
id = emp_id.tolist()

msg.completed_message()