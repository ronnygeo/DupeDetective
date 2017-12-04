from sklearn.neural_network import MLPClassifier

X = [[0., 0., 0., 0., 0.], [1., 1., 1., 1., 1.]]
y = [0, 1]
clf = MLPClassifier(solver='lbfgs', alpha=1e-5,
                     hidden_layer_sizes=(5,), random_state=1, warm_start=True)

clf.fit(X, y)
