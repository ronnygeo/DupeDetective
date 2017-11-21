package cs5500.project.db;

import com.mongodb.*;
import cs5500.project.ReadProperties;
import java.util.ArrayList;
import java.util.List;

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
        }
     }


    /**
     * Gets all the files of an assignment
     * @param assignmentId the assignment id
     * @return a list of submissions
     */
     public List<Submission> getSubmissions(Integer assignmentId) {
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
                 Submission submission = new Submission();
                 submission.createFromMongoObj(cursor.next());
                 l.add(submission);
             }
         }
         return l;
     }

    /**
     * save the submission to mongo
     * @param submission a submission object
     */
     public void saveSubmission(Submission submission) {
         DB db;
         DBCollection collection;
         try (MongoClient mongoClient = new MongoClient(host, port)) {
             db = mongoClient.getDB(database);
             collection = db.getCollection(colSubmission);
             collection.insert(getSubmissionDocument(submission));
         }
     }

    /**
     * save the assigment to mongo
     * @param assignment a submission object
     */
    public void saveAssignment(Assignment assignment) {
        DB db;
        DBCollection collection;
        try (MongoClient mongoClient = new MongoClient(host, port)) {
            db = mongoClient.getDB(database);
            collection = db.getCollection(colAssignment);
            collection.insert(getAssignmentDocument(assignment));
        }
    }

    /**
     * Convert Report object to mongo object
     * @param report the Report object
     * @return the mongoDB object
     */
    private BasicDBObject getReportDocument(Report report) {
        BasicDBObject document = new BasicDBObject();
        document.put("refFileId", report.getRefFileId());
        document.put("similarFileId", report.getSimilarFileId());
        document.put("submissionId", report.getSubmissionId());

        List<BasicDBObject> dbItems = new ArrayList<>();

        for (ReportItem ri: report.getItems()) {
            BasicDBObject documentDetail = new BasicDBObject();
            documentDetail.put("refFileOffset", ri.getRefOffset());
            documentDetail.put("similarFileOffset", ri.getSimilarOffset());
            documentDetail.put("refFileLength", ri.getRefLength());
            documentDetail.put("similarFileLength", ri.getSimilarLength());
            documentDetail.put("model", ri.getModel());
            documentDetail.put("score", ri.getScore());
            dbItems.add(documentDetail);
        }
        document.put("lines", dbItems);
        return document;
    }

    /**
     * Convert Submission object to mongo object
     * @param submission the Submission object
     * @return the mongoDB object
     */
    private BasicDBObject getSubmissionDocument(Submission submission) {
        BasicDBObject document = new BasicDBObject();
        document.put("assignmentId", submission.getAssignmentId());
        document.put("studentId", submission.getStudentId());
        document.put("filename", submission.getFilename());
        document.put("filecontent", submission.getFilecontent());
        document.put("checksum", submission.getChecksum());
        document.put("name", submission.getName());
        document.put("submittedOn", submission.getSubmittedOn());
        return document;
    }

    /**
     * Convert Assignment object to mongo object
     * @param assignment the Assignment object
     * @return the mongoDB object
     */
    private BasicDBObject getAssignmentDocument(Assignment assignment) {
        BasicDBObject document = new BasicDBObject();
        document.put("assignmentId", assignment.getName());
        document.put("studentId", assignment.getYear());
        document.put("filename", assignment.isAnalyzed());
        document.put("filecontent", assignment.getCourse());
        document.put("checksum", assignment.getCreationDate());
        document.put("name", assignment.getDueDate());
        document.put("submittedOn", assignment.getAnalyzedDate());
        return document;
    }
}
