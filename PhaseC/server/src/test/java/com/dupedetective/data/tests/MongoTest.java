package com.dupedetective.data.tests;

import com.dupedetective.data.Assignment;
import com.dupedetective.data.MongoOperation;
import com.dupedetective.data.Report;
import com.dupedetective.data.Submission;
import com.dupedetective.engine.Model;
import com.dupedetective.engine.ReadProperties;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class that performs operations on mongo for the backend
 */
public class MongoTest {
        final static Logger logger = Logger.getLogger(MongoTest.class);
        private String database;
        private String host;
        private String port;
        private String colReport;
        private String colSubmission;
        private String colAssignment;
        private final String PROPERTIES_FILE_TEST = "mongo-test.properties";
        private Map<Integer, Float> weights;
        private MongoOperation mongo;

        @Before
        public void setup() {
            ReadProperties mongoProps = new ReadProperties();
            host = mongoProps.readKey(PROPERTIES_FILE_TEST, "host");
            port = mongoProps.readKey(PROPERTIES_FILE_TEST, "port");
            database = mongoProps.readKey(PROPERTIES_FILE_TEST, "db");
            colReport = mongoProps.readKey(PROPERTIES_FILE_TEST, "colReport");
            colSubmission = mongoProps.readKey(PROPERTIES_FILE_TEST, "colSubmission");
            colAssignment = mongoProps.readKey(PROPERTIES_FILE_TEST, "colAssignment");
            mongo = new MongoOperation(host, port, database, colReport, colSubmission, colAssignment);

            weights = new HashMap<>();
            weights.put(Model.ASTLoop.getValue(), 0.25f);
            weights.put(Model.ASTMethod.getValue(), 0.25f);
            weights.put(Model.ASTStructure.getValue(), 0.5f);
            weights.put(Model.WINNOWING.getValue(), 0.00f);
        }

        @Test
        public void testConstructor() {
            MongoOperation mongoLive = new MongoOperation();
        }

        @Test
        public void saveReportTest() {
            DB db;
            DBCollection collection;
            Report report = new Report("1", "1", "1");
            mongo.saveReport(report);
            try (MongoClient mongoClient = new MongoClient(host, Integer.parseInt(port))) {
                db = mongoClient.getDB(database);
                collection = db.getCollection(colReport);
                assertEquals(1, collection.getCount());
                collection.drop();
            } catch (MongoSocketException mso) {
                logger.error(mso.getMessage());
            }
        }

        @Test
        public void getSubmissionsTest() {
            Submission submission = new Submission("1", "Test", "1");
            List<Submission> l = new ArrayList<>();
            l.add(submission);
            submission.setAssignmentId("1");
            DB db;
            DBCollection collection;
            Gson gson = new Gson();
            MongoOperation mongo = new MongoOperation(host, port, database, colReport, colSubmission, colAssignment);
            try (MongoClient mongoClient = new MongoClient(host, Integer.parseInt(port))) {
                db = mongoClient.getDB(database);
                collection = db.getCollection(colSubmission);
                BasicDBObject obj = (BasicDBObject) JSON.parse(gson.toJson(submission));
                collection.insert(obj);
                logger.info(mongo.getSubmissions("1").size());
                assertEquals(l.size(), mongo.getSubmissions("1").size());
                collection.drop();
            } catch (MongoSocketException mso) {
                logger.error(mso.getMessage());
            }
        }

        @Test
        public void updateAnalyzedAssignmentTests() {
            Assignment assignment = new Assignment();
            assignment.setName("HW1");
            assignment.setCourse("CS5500");
            assignment.setAnalyzed(false);
            ObjectId id;
            try (MongoClient mongoClient = new MongoClient(host, Integer.parseInt(port))) {
                DB db;
                DBCollection collection;
                Gson gson = new Gson();
                db = mongoClient.getDB(database);
                collection = db.getCollection(colAssignment);
                BasicDBObject obj = (BasicDBObject) JSON.parse(gson.toJson(assignment));
                collection.insert(obj);
                id = obj.getObjectId("_id");
                logger.info(id);
            }
            mongo.updateAnalyzedAssignment(id.toString());
            try (MongoClient mongoClient = new MongoClient(host, Integer.parseInt(port))) {
                DB db;
                DBCollection collection;
                db = mongoClient.getDB(database);
                collection = db.getCollection(colAssignment);
                BasicDBObject searchQuery = new BasicDBObject();
                searchQuery.put("_id", id);
                DBObject obj = collection.findOne(searchQuery);
                assertEquals(true, obj.get("isAnalyzed"));
                collection.drop();
            } catch (MongoSocketException mso) {
                logger.error(mso.getMessage());
            }
        }

}
