import os
from sklearn.externals import joblib
import Tune_Params as tune
import DBAccess as db_connect
import Messages as msg
import numpy as np
import pandas

mysql_cn = db_connect.DBConnect()

os.system('D:\SLIIT\SoftwareIndustry\Accuracy_IT.py')

max_accuracy = mysql_cn.read("SELECT algo_id as 'id' FROM accuracy_confusion_mse WHERE confusion_accuracy = "
                             "(SELECT MAX(confusion_accuracy) FROM accuracy_confusion_mse)")
id = max_accuracy['id'].tolist()

if id[0] == 1:
    os.system('D:\SLIIT\SoftwareIndustry\Train_KNN.py')
elif id[0] == 2:
    os.system('D:\SLIIT\SoftwareIndustry\Train_RF.py')
elif id[0] == 3:
    os.system('D:\SLIIT\SoftwareIndustry\Train_SVM.py')