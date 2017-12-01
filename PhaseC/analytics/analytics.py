from flask import Flask, jsonify
from sklearn.externals import joblib
import pandas as pd

app = Flask(__name__)


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
    json_ = request.json
    query_df = pd.DataFrame(json_)
    query = pd.get_dummies(query_df)
    prediction = clf.predict(query)
    return jsonify({'prediction': list(prediction)})


@app.route('/fit', methods=['POST'])
def fit():
    """
    update the model with the new data
    :return: the new score from the network
    """
    json_ = request.json
    query_df = pd.DataFrame(json_)
    query = pd.get_dummies(query_df)
    prediction = clf.predict(query)
    return jsonify({'prediction': list(prediction)})

if __name__ == '__main__':
    clf = joblib.load('model.pkl')
    app.run(port=3000)
