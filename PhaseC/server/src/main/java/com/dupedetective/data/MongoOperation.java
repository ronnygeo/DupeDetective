package com.dupedetective.data;

import com.dupedetective.engine.Model;
import com.dupedetective.engine.ReadProperties;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that performs operations on mongo for the backend
 */
public class MongoOperation {
    final static Logger logger = Logger.getLogger(MongoOperation.class);
    private String database;
    private String host;
    private Integer port;
    private String colReport;
    private String colSubmission;
    private String colAssignment;
    private final String PROPERTIES_FILE = "mongo.properties";
    private Map<Integer, Float> weights;

    /**
     * Default constructor
     */
    public MongoOperation() {
        ReadProperties mongoProps = new ReadProperties();
        host = mongoProps.readKey(PROPERTIES_FILE, "host");
        port = Integer.parseInt(mongoProps.readKey(PROPERTIES_FILE, "port"));
        database = mongoProps.readKey(PROPERTIES_FILE, "db");
        colReport = mongoProps.readKey(PROPERTIES_FILE, "colReport");
        colSubmission = mongoProps.readKey(PROPERTIES_FILE, "colSubmission");
        colAssignment = mongoProps.readKey(PROPERTIES_FILE, "colAssignment");
        weights = new HashMap<>();
        weights.put(Model.ASTLoop.getValue(), 0.25f);
        weights.put(Model.ASTMethod.getValue(), 0.25f);
        weights.put(Model.ASTStructure.getValue(), 0.5f);
        weights.put(Model.WINNOWING.getValue(), 0.00f);
    }

    /**
     * @param report the ModelReport object to insert
     */
    public void saveReport(Report report) {
        DB db;
        DBCollection collection;
        Gson gson = new Gson();
        try (MongoClient mongoClient = new MongoClient(host, port)) {
            db = mongoClient.getDB(database);
            collection = db.getCollection(colReport);
            logger.info(report);
            BasicDBObject obj = (BasicDBObject) JSON.parse(gson.toJson(report));
            collection.insert(obj);
            logger.info("report saved to mongo.");
        }
     }


    /**
     * Gets all the files of an assignment
     * @param assignmentId the assignment id
     * @return a list of submissions
     */
     public List<Submission> getSubmissions(String assignmentId) {
         List<Submission> l = new ArrayList<>();
         BasicDBObject searchQuery;
         DBCursor cursor;

         try (MongoClient mongoClient = new MongoClient(host, port)) {
             DB db = mongoClient.getDB(database);
             DBCollection collection = db.getCollection(colSubmission);
             searchQuery = new BasicDBObject();
             searchQuery.put("assignmentId", assignmentId);
             cursor = collection.find(searchQuery);

             while (cursor.hasNext()) {
                 DBObject dbo = cursor.next();
                 if (dbo != null) {
                     Submission submission = new Submission();
                     submission.createFromMongoObj(dbo);
                     l.add(submission);
                 }
             }
         }
         return l;
     }

    /**
     * Update the Analyzed flag of Analyzed Assignments
     * @param assignmentId assignment Id
     */
     public void updateAnalyzedAssignment(String assignmentId) {
         try (MongoClient mongoClient = new MongoClient(host, port)) {
             DB db = mongoClient.getDB(database);
             BasicDBObject newDocument = new BasicDBObject();
             newDocument.append("$set", new BasicDBObject().append("analyzedDate", LocalDateTime.now().toString()));
             BasicDBObject searchQuery = new BasicDBObject().append("_id", new ObjectId(assignmentId));
             DBCollection collection = db.getCollection(colAssignment);
             collection.update(searchQuery, newDocument);

             BasicDBObject newDocument2 = new BasicDBObject();
             newDocument2.append("$set", new BasicDBObject().append("isAnalyzed", true));
             collection.update(searchQuery, newDocument2);
         }
     }
}
