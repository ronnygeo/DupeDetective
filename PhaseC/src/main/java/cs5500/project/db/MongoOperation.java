package cs5500.project.db;

import com.mongodb.*;
import cs5500.project.ReadProperties;
import cs5500.project.engine.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that performs operations on mongo for the backend
 */
public class MongoOperation {

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
     * @param report the Report object to insert
     */
    public void saveReport(Report report) {

        DB db;
        DBCollection collection;
        try (MongoClient mongoClient = new MongoClient(host, port)) {
            db = mongoClient.getDB(database);
            collection = db.getCollection(colReport);
            collection.insert(getReportDocument(report));
            System.out.println("report saved to mongo.");
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
     * Convert Report object to mongo object
     * @param report the Report object
     * @return the mongoDB object
     */
    private BasicDBObject getReportDocument(Report report) {
        BasicDBObject document = new BasicDBObject();
        Map<Integer, Float> scores = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        document.put("refFileId", report.getRefFileId());
        document.put("similarFileId", report.getSimilarFileId());
        document.put("submissionId", report.getSubmissionId());

        List<BasicDBObject> dbItems = new ArrayList<>();

        //TODO: Refactor this whole method
        for (ReportLine ri: report.getLines()) {
            BasicDBObject documentDetail = new BasicDBObject();
            documentDetail.put("refFileOffset", ri.getRefOffset());
            documentDetail.put("similarFileOffset", ri.getSimilarOffset());
            documentDetail.put("refFileLength", ri.getRefLength());
            documentDetail.put("similarFileLength", ri.getSimilarLength());
            documentDetail.put("model", ri.getModel());
            documentDetail.put("score", ri.getScore());
            dbItems.add(documentDetail);
            scores.put(ri.getModel(), scores.getOrDefault(ri.getModel(), 0.0f) + ri.getScore());
            count.put(ri.getModel(), count.getOrDefault(ri.getModel(), 0) + 1);
        }

        document.put("md5Result", scores.get(Model.MD5.getValue()) == 1);
        document.put("structureScore", scores.getOrDefault(Model.ASTStructure.getValue(), 0f)/count.getOrDefault(Model.ASTStructure.getValue(), 1));
        document.put("loopScore", scores.getOrDefault(Model.ASTLoop.getValue(), 0f)/count.getOrDefault(Model.ASTLoop.getValue(), 1));
        document.put("methodScore", scores.getOrDefault(Model.ASTMethod.getValue(), 0f)/count.getOrDefault(Model.ASTMethod.getValue(), 1));
        document.put("winnowingScore", scores.getOrDefault(Model.WINNOWING.getValue(), 0f)/count.getOrDefault(Model.WINNOWING.getValue(), 1));

        float overallScore = 0;
        for (Integer key: scores.keySet()) {
            if (key != Model.MD5.getValue()) {
                overallScore += weights.get(key) * (scores.getOrDefault(key, 0f)/count.getOrDefault(key, 1));
            }
        }
        document.put("overallScore", overallScore);
        document.put("lines", dbItems);
        return document;
    }
}
