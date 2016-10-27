import numpy as np
from sklearn.grid_search import GridSearchCV
from sklearn.neighbors import KNeighborsClassifier as KNN
from sklearn.ensemble import RandomForestClassifier as RF
from sklearn.svm import SVC
import DBAccess as db_connect
import Messages as msg


class TuneParams(object):
    mysql_cn = None
    is_tune_needed = None
    check_tune = None

    def __init__(self):
        self.mysql_cn = db_connect.DBConnect()
        self.is_tune_needed = self.mysql_cn.read("SELECT * FROM tune_user_selection")
        self.check_tune = self.is_tune_needed['is_tune_needed'].tolist()

    def tune_knn(self, X, y):
        msg.tune_knn_message()
        k_value = None
        msg.loading_message()
        k_params = self.mysql_cn.read('select * from params_knn;')
        k = k_params['k_value'].tolist()
        if not k:
            msg.tuning_message()
            range_k = list(range(1, 31))
            param_grid = {
                'n_neighbors': range_k
            }
            CV_knn = GridSearchCV(estimator=KNN(), param_grid=param_grid, cv=10)
            CV_knn.fit(X, y)
            k_value_param = CV_knn.best_params_
            k_value = k_value_param['n_neighbors']
            k = k_value
            msg.print_knn_params(k)
            msg.insert_message()
            self.mysql_cn.insert_update("INSERT INTO params_knn(k_value) VALUES(%d)" % k_value)
            return k
        elif self.check_tune[0]:
            msg.tuning_message()
            range_k = list(range(1, 31))
            param_grid = {
                'n_neighbors': range_k
            }
            CV_knn = GridSearchCV(estimator=KNN(), param_grid=param_grid, cv=10)
            CV_knn.fit(X, y)
            k_value_param = CV_knn.best_params_
            k_value = k_value_param['n_neighbors']
            k = k_value
            msg.print_knn_params(k)
            msg.update_message()
            self.mysql_cn.insert_update("UPDATE params_knn SET k_value=%d" % k_value)
            return k
        else:
            msg.loading_message()
            new_k = self.mysql_cn.read('select * from params_knn;')
            k_value = new_k['k_value'].tolist()
            k = k_value[0]
            msg.print_knn_params(k)
            return k

    def tune_rf(self, X, y):
        msg.print_line()
        msg.tune_rf_message()
        estimators = None
        features = None
        leaf = None
        msg.loading_message()
        rf_params = self.mysql_cn.read('select * from params_rf;')
        n_estimators = rf_params['n_estimators'].tolist()
        max_features = rf_params['max_features'].tolist()
        min_samples_leaf = rf_params['min_samples_leaf'].tolist()
        if not n_estimators or not max_features or not min_samples_leaf:
            msg.tuning_message()
            param_grid = {
                'n_estimators': [10],
                'max_features': ['auto', 'sqrt', 'log2'],
                'min_samples_leaf': [1, 5, 10]
            }
            CV_rf = GridSearchCV(estimator=RF(), param_grid=param_grid, cv=5)
            CV_rf.fit(X, y)
            rf_param = CV_rf.best_params_
            n_estimators = rf_param['n_estimators']
            max_features = rf_param['max_features']
            min_samples_leaf = rf_param['min_samples_leaf']
            msg.print_rf_params(n_estimators, max_features, min_samples_leaf)
            msg.insert_message()
            self.mysql_cn.insert_update("INSERT INTO params_rf(n_estimators, max_features, min_samples_leaf) "
                                        "VALUES(%d, '%s', %d)" % (n_estimators, max_features, min_samples_leaf))
            return (n_estimators, max_features, min_samples_leaf)
        elif self.check_tune[0]:
            msg.tuning_message()
            param_grid = {
                'n_estimators': [10, 100],
                'max_features': ['auto', 'sqrt', 'log2'],
                'min_samples_leaf': [1, 5, 10]
            }
            CV_rf = GridSearchCV(estimator=RF(), param_grid=param_grid, cv=5)
            CV_rf.fit(X, y)
            rf_param = CV_rf.best_params_
            n_estimators = rf_param['n_estimators']
            max_features = rf_param['max_features']
            min_samples_leaf = rf_param['min_samples_leaf']
            msg.print_rf_params(n_estimators, max_features, min_samples_leaf)
            msg.update_message()
            self.mysql_cn.insert_update(
                "UPDATE params_rf SET n_estimators = %d, max_features = '%s', min_samples_leaf = %d"
                        % (n_estimators, max_features, min_samples_leaf))
            return (n_estimators, max_features, min_samples_leaf)
        else:
            msg.loading_message()
            new_rf_params = self.mysql_cn.read('select * from params_rf;')
            estimators = new_rf_params['n_estimators'].tolist()
            features = new_rf_params['max_features'].tolist()
            leaf = new_rf_params['min_samples_leaf'].tolist()
            n_estimators = estimators[0]
            max_features = features[0]
            min_samples_leaf = leaf[0]
            msg.print_rf_params(n_estimators, max_features, min_samples_leaf)
            return (n_estimators, max_features, min_samples_leaf)

    def tune_svm(self, X, y):
        msg.print_line()
        msg.tune_svm_message()
        C_range = np.logspace(-2, 2, 9)
        gamma_range = np.logspace(-2, 2, 9)
        param_grid = [{'kernel': ['rbf'], 'gamma': gamma_range, 'C': C_range}]
        msg.loading_message()
        svm_params = self.mysql_cn.read('select * from params_svm;')
        kernel = svm_params['kernel'].tolist()
        c = svm_params['c'].tolist()
        gamma = svm_params['gamma'].tolist()
        if not kernel:
            msg.tuning_message()
            CV_svm = GridSearchCV(SVC(), param_grid=param_grid, cv=5)
            CV_svm.fit(X, y)
            svm_params = CV_svm.best_params_
            kernel = svm_params['kernel']
            c = svm_params['C']
            gamma = svm_params['gamma']
            msg.print_svm_params(kernel, c, gamma)
            msg.insert_message()
            self.mysql_cn.insert_update("INSERT INTO params_svm(kernel, c, gamma) "
                                        "VALUES('%s', %s, %s)" % (kernel, c, gamma))
            return (kernel, c, gamma)
        elif self.check_tune[0]:
            msg.tuning_message()
            CV_svm = GridSearchCV(SVC(), param_grid=param_grid, cv=5)
            CV_svm.fit(X, y)
            svm_params = CV_svm.best_params_
            kernel = svm_params['kernel']
            c = svm_params['C']
            gamma = svm_params['gamma']
            msg.print_svm_params(kernel, c, gamma)
            msg.update_message()
            self.mysql_cn.insert_update(
                "UPDATE params_svm SET kernel = '%s', c = %s, gamma = %s"
                % (kernel, c, gamma))
            return (kernel, c, gamma)
        else:
            msg.loading_message()
            new_svm_params = self.mysql_cn.read('select * from params_svm;')
            kernel = new_svm_params['kernel'].tolist()
            c = new_svm_params['c'].tolist()
            gamma = new_svm_params['gamma'].tolist()
            msg.print_svm_params(kernel[0], c[0], gamma[0])
            return (kernel[0], c[0], gamma[0])