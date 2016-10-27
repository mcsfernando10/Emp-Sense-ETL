import numpy as np
from sklearn.neighbors import KNeighborsClassifier as KNN
from sklearn.metrics import mean_squared_error
from sklearn.ensemble import RandomForestClassifier as RF
from sklearn.svm import SVC
import DBAccess as db_connect
import Messages as msg
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

def reason_predict(X,y,clf_class,**kwargs):
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.4)
    clf = clf_class(**kwargs)
    clf.fit(X_train, y_train)
    reason = clf.predict(X_test)
    return reason, y_test

def accuracy(y_true,y_pred):
    return mean_squared_error(y_true, y_pred)

y_pred_reason_knn, y_test_knn = reason_predict(X_reason,y_reason, KNN)

y_pred_reason_rf, y_test_rf = reason_predict(X_reason, y_reason, RF)

y_pred_reason_svm, y_test_svm = reason_predict(X_reason, y_reason, SVC)

msg.print_line()
msg.mse_message()

print("K-nearest-neighbors (MSE-Reason):")
mse_knn_reason = round(accuracy(y_test_knn, y_pred_reason_knn), 3)
print(mse_knn_reason)
print()
print("Random Forest (MSE-Reason):")
mse_rf_reason = round(accuracy(y_test_rf, y_pred_reason_rf), 3)
print(mse_rf_reason)
print()
print("Support Vector Machine (MSE-Reason):")
mse_svm_reason = round(accuracy(y_test_svm, y_pred_reason_svm), 3)
print(mse_svm_reason)
print()

from sklearn.metrics import confusion_matrix, accuracy_score

confusion_knn_reason = confusion_matrix(y_test_knn, y_pred_reason_knn)
confusion_rf_reason = confusion_matrix(y_test_rf, y_pred_reason_rf)
confusion_svm_reason = confusion_matrix(y_test_svm, y_pred_reason_svm)

confusion_matrices_reason = [
    ("K-Nearest-Neighbors (reason) ", confusion_knn_reason),
    ("Random Forest (reason) ", confusion_rf_reason),
    ("Random Support Vector Machine (reason) ", confusion_svm_reason)
]

print(confusion_matrices_reason)
print()
msg.confusion_message()
print()

acc_knn_reason = round(accuracy_score(y_test_knn, y_pred_reason_knn), 3)
acc_rf_reason = round(accuracy_score(y_test_rf, y_pred_reason_rf), 3)
acc_svm_reason = round(accuracy_score(y_test_svm, y_pred_reason_svm), 3)

print('Confusion Accuracy_KNN (reason): ', acc_knn_reason)
print('Confusion Accuracy_RF (reason): ', acc_rf_reason)
print('Confusion Accuracy_SVM (reason): ', acc_svm_reason)

mse_reason = np.array([mse_knn_reason, mse_rf_reason, mse_svm_reason])
mse_reason.tolist()

conf_accuracy_reason = np.array([acc_knn_reason, acc_rf_reason, acc_svm_reason])
conf_accuracy_reason.tolist()

msg.update_message()
columns = mysql_cn.read('select * from accuracy_confusion_mse')
algo_id = columns['algo_id'].tolist()

for id in range(0,len(algo_id)):
    mysql_cn.insert_update("UPDATE accuracy_confusion_mse_reason SET confusion_accuracy = %s, mean_squared_error = %s "
                           "WHERE algo_id = %d" % (conf_accuracy_reason[id], mse_reason[id], algo_id[id]))

msg.completed_message()