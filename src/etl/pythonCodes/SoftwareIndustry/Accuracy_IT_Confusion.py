import numpy as np
from sklearn.neighbors import KNeighborsClassifier as KNN
from sklearn.metrics import mean_squared_error
from sklearn.ensemble import RandomForestClassifier as RF
from sklearn.svm import SVC
import DBAccess as db_connect
import Tune_Params as tune
import Messages as msg

mysql_cn = db_connect.DBConnect()
tune_params = tune.TuneParams()

# Read in the data.
msg.loading_message()
df_mysql = mysql_cn.read('select * from employeesit_raw_train;')
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
print('X: ',X.shape)

from sklearn.cross_validation import KFold

def cv_predict(X,y,clf_class,**kwargs):
    # Construct a kfolds object
    kf = KFold(len(y),n_folds=3,shuffle=True)
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

def accuracy(y_true,y_pred):
    return mean_squared_error(y_true, y_pred)

k = tune_params.tune_knn(X, y)
y_pred_knn = cv_predict(X, y, KNN, n_neighbors=k)

n_estimators, max_features, min_samples_leaf = tune_params.tune_rf(X, y)
y_pred_rf = cv_predict(X, y, RF, n_estimators=n_estimators, max_features=max_features, min_samples_leaf=min_samples_leaf)

kernel, c, gamma = tune_params.tune_svm(X, y)
y_pred_svm = cv_predict(X, y, SVC, kernel=kernel, C=c, gamma=gamma)

msg.print_line()
msg.mse_message()

print("K-nearest-neighbors (MSE):")
mse_knn = round(accuracy(y, y_pred_knn), 3)
print(mse_knn)
print()
print("Random Forest (MSE):")
mse_rf = round(accuracy(y, y_pred_rf), 3)
print(mse_rf)
print()
print("Support Vector Machine (MSE):")
mse_svm = round(accuracy(y, y_pred_svm), 3)
print(mse_svm)
print()

from sklearn.metrics import confusion_matrix, accuracy_score

confusion_knn = confusion_matrix(y, y_pred_knn)
confusion_rf = confusion_matrix(y, y_pred_rf)
confusion_svm = confusion_matrix(y, y_pred_svm)

confusion_matrices = [
    ( "K-Nearest-Neighbors", confusion_knn),
    ( "Random Forest", confusion_rf),
    ( "Random Support Vector Machine", confusion_svm)
]

print(confusion_matrices)
print()
msg.confusion_message()
print()

acc_knn = round(accuracy_score(y, y_pred_knn), 3)
acc_rf = round(accuracy_score(y, y_pred_rf), 3)
acc_svm = round(accuracy_score(y, y_pred_svm), 3)

print('Confusion Accuracy_KNN: ', acc_knn)
print('Confusion Accuracy_RF:', acc_rf)
print('Confusion Accuracy_SVM:', acc_svm)

import pylab as pl

cm = confusion_matrix(y,run_cv(X,y,SVC))
fig = pl.figure()
ax = fig.add_subplot(111)
cax = ax.matshow(cm)
pl.title('Confusion matrix of the SVM classifier')
fig.colorbar(cax)

pl.xlabel('True Class')
pl.ylabel('Predicted Class')
pl.show()


cm = confusion_matrix(y,run_cv(X,y,RF))
fig = pl.figure()
ax = fig.add_subplot(111)
cax = ax.matshow(cm)
pl.title('Confusion matrix of the Random Forest classifier')
fig.colorbar(cax)

pl.xlabel('True Class')
pl.ylabel('Predicted Class')
pl.show()


cm = confusion_matrix(y,run_cv(X,y,KNN))
fig = pl.figure()
ax = fig.add_subplot(111)
cax = ax.matshow(cm)
pl.title('Confusion matrix of the K-nearest classifier')
fig.colorbar(cax)

pl.xlabel('True Class')
pl.ylabel('Predicted Class')
pl.show()


mse = np.array([mse_knn, mse_rf, mse_svm])
mse.tolist()

conf_accuracy = np.array([acc_knn, acc_rf, acc_svm])
conf_accuracy.tolist()

msg.update_message()
columns = mysql_cn.read('select * from accuracy_confusion_mse')
algo_id = columns['algo_id'].tolist()

for id in range(0,len(algo_id)):
    mysql_cn.insert_update("UPDATE accuracy_confusion_mse SET confusion_accuracy = %s, mean_squared_error = %s "
                           "WHERE algo_id = %d" % (conf_accuracy[id], mse[id], algo_id[id]))

msg.completed_message()