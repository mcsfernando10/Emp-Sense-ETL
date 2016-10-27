import os
from sklearn.externals import joblib
import Tune_Params as tune
import DBAccess as db_connect
import Messages as msg
import numpy as np
import pandas

mysql_cn = db_connect.DBConnect()

os.system('D:\SLIIT\ITIndustry\Reason\Accuracy_IT.py')

max_accuracy = mysql_cn.read("SELECT algo_id as 'id' FROM accuracy_confusion_mse_reason WHERE confusion_accuracy = "
                             "(SELECT MAX(confusion_accuracy) FROM accuracy_confusion_mse_reason)")
id = max_accuracy['id'].tolist()

if id[0] == 1:
    os.system('D:\SLIIT\ITIndustry\Reason\Train_KNN.py')
elif id[0] == 2:
    os.system('D:\SLIIT\ITIndustry\Reason\Train_RF.py')
elif id[0] == 3:
    os.system('D:\SLIIT\ITIndustry\Reason\Train_SVM.py')