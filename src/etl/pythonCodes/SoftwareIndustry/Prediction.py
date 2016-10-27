from sklearn.externals import joblib
from sklearn.neighbors import KNeighborsClassifier
import Tune_Params as tune
import DBAccess as db_connect
import Messages as msg
import numpy as np
import pandas
import sys

mysql_cn = db_connect.DBConnect()
mysql_cn.insert_update("UPDATE tune_user_selection SET is_tune_needed = 0")
tune_params = tune.TuneParams()

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
    clf = joblib.load('D:\SLIIT\SoftwareIndustry\knn_model.pkl')
    pred_prob = clf.predict_proba(X)
    pred_churn = pred_prob[:, 1]
elif int(algo_id[0]) == 2:
    print("Random Forest")
    clf = joblib.load('D:\SLIIT\SoftwareIndustry\df_model.pkl')
    pred_prob = clf.predict_proba(X)
    pred_churn = pred_prob[:, 1]
else:
    print("Support Vector Machine")
    clf = joblib.load('D:\SLIIT\SoftwareIndustry\svm_model.pkl')
    pred_prob = clf.predict_proba(X)
    pred_churn = pred_prob[:, 1]


# Number of times a predicted probability is assigned to an observation
counts = pandas.value_counts(np.ndarray.round(pred_churn, 3))
counts = pandas.concat([counts], axis=1).reset_index()

counts.columns = ['pred_prob', 'count']
print(counts)

df1 = pandas.DataFrame(counts).sort_values(by='pred_prob')
counts_list = df1.values.tolist()

mysql_cn.delete("DELETE FROM prob_counts")

for row in range(0, len(counts_list)):
    x = counts_list[row]
    mysql_cn.insert_update("INSERT INTO prob_counts(probability, emp_count) VALUES(%s, %d)" % (x[0], x[1]))

data_id = mysql_cn.read('select * from employeesit_predict')
emp_id = data_id['Employee_ID']
id = emp_id.tolist()

probability = np.ndarray.round(pred_churn, 3)
probability.tolist()

msg.update_message()
for num in range(0,len(id)):
    mysql_cn.insert_update("UPDATE employeesit_predict SET probability=%s WHERE Employee_ID='%s'" % (probability[num], id[num]))

if int(algo_id[0]) == 2:
    mysql_cn.delete('TRUNCATE TABLE employeesit_predict_feature_cont')
    from treeinterpreter import treeinterpreter as ti

    print("Feature Contribution (Random Forest)")
    clf = joblib.load('D:\SLIIT\SoftwareIndustry\df_model.pkl')

    df_emp = mysql_cn.read('select * from employeesit_predict')
    emp_id = df_emp['Employee_ID']
    emp_name = df_emp['Employee_Name']
    id = emp_id.tolist()
    e_name = emp_name.tolist()

    arr_con = np.zeros(len(features))
    arr_gain_lost = np.zeros(len(features))
    arr_feature = np.zeros(len(features))
    msg.update_message()
    for index in range(len(X)):
        i = X[index:index + 1]
        prediction, bias, contributions = ti.predict(clf, i)
        a = 0
        for c, feature in zip(contributions[0], features):
            arr_con[a] = round(c[1] * 100, 2)
            # arr_feature[a] = feature
            # arr_gain_lost[a]=round(c[1], 2)
            a = a + 1
            arr_con_list = arr_con.tolist()
        max_value = max(arr_con_list)
        max_index = arr_con_list.index(max_value)
        mysql_cn.insert_update(
            "INSERT INTO `employeesit_predict_feature_cont`(`Employee_ID`, `Employee_Name`, `Age`, `Gender`, `Marital_Status`, "
            "`Having_Degree`, `Job_Role`, `Department`, `WorkFrom`, `WorkTo`, `Tenure`, `Salary`, `Bonus`, `Claims`, `Worked_Project`, `No_of_Leaves`, "
            "`Distance`, `No_of_Parents`, `No_of_Children`, `No_of_Complaints`, `Bias`, `Prediction_Probability`, `Max_Feature`) "
            "VALUES('%s','%s',%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,'%s')" %
            (id[index], e_name[index], arr_con[0], arr_con[1], arr_con[2], arr_con[3], arr_con[4], arr_con[5],
             arr_con[6], arr_con[7], arr_con[8], arr_con[9], arr_con[10], arr_con[11], arr_con[12], arr_con[13], arr_con[14],
             arr_con[15], arr_con[16], arr_con[17], round(bias[0][1] * 100, 2), round(prediction[0][1] * 100, 2), features[max_index]))

msg.completed_message()