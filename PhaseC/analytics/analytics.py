from flask import Flask, jsonify, request
from flask_cors import CORS, cross_origin
from sklearn.externals import joblib
import os

# Defining this as flask App
app = Flask(__name__)
CORS(app)

MODEL_NAME = "model.pkl"

@app.route('/')
def hello_world():
    """
    root route
    :return: response to the call
    """
    return 'Hello from Analytics!'

@app.route('/predict', methods=['POST'])
def predict():
    """
    get the score predictions from the neural network
    :return: the score from the network
    """
    json_ = request.get_json()
    if json_:
        train = [json_["train"]]
        print(train)
        prediction = clf.predict(train)
        print(prediction)
        return jsonify({'prediction': prediction[0]})
    return "0"

@app.route('/fit', methods=['POST'])
def fit():
    """
    update the model with the new data
    :return: the new score from the network
    """
    json_ = request.get_json()
    if json_:
        train = [json_["train"]]
        label = [json_["label"]]
        print(train, label)
        clf.fit(train, label)
        prediction = clf.predict(train)
        joblib.dump(clf, MODEL_NAME)
        return jsonify({'prediction': prediction[0]})
    return "0"

if __name__ == '__main__':
    clf = joblib.load(os.path.join(os.getcwd(), MODEL_NAME))
    app.run(port=3000)
