def tuning_message():
    print('Tuning in process..')


def insert_message():
    print('Inserting to database..')


def update_message():
    print('Updating database..')


def loading_message():
    print('Loading data from database..')


def tune_knn_message():
    print('Tuning K-Nearest-Neighbors Parameters')


def tune_rf_message():
    print('Tuning Random Forest Parameters')


def tune_svm_message():
    print('Tuning Support Vector Machine Parameters')


def print_knn_params(k_value):
    print('K_Value: ', k_value)


def print_rf_params(n_estimators, max_features, leaf):
    print('n_estimators: %d, max_features: %s, min_samples_leaf: %d' % (n_estimators, max_features, leaf))


def print_svm_params(kernel, c, gamma):
    print('Kernel: %s, C: %s, Gamma: %d' % (kernel, c, gamma))


def print_line():
    print()
    print('--------------------------------------------------------------------')
    print()


def mse_message():
    print('Calculating Mean Squared Error..')


def confusion_message():
    print('Calculating Confusion Accuracy..')


def calculate_probs_message():
    print('Calculating Probabilities')


def completed_message():
    print('Complete!!')


def exit_message():
    confirm = input("Press enter to continue")
    print(confirm)