from sklearn.neural_network import MLPRegressor
from sklearn.externals import joblib

# Initial train data
X = [[0., 0., 0., 0., 0.],
     [1., 1., 1., 1., 1.],
    [1., 0., 0., 0., 0.],
    [1., 0., 0., 0., 0.],
    [1., 0., 0., 0., 0.],
    [1., 0., 0., 0., 0.],
    [0., 0.5, 0.4, 0.5, 0.5]
     ]
y = [0, 1, 1, 1, 1, 1, 0.5]

# Initializing regressor
clf = MLPRegressor(solver='adam', alpha=1e-5,
                     hidden_layer_sizes=(5,), random_state=9, warm_start=True)

# Fitting train data
clf.fit(X, y)

# Write model to folder
joblib.dump(clf, 'model.pkl')
