package cs5500.project.db;

import com.mongodb.*;
import cs5500.project.spring.data.Report;
import cs5500.project.spring.data.ReportItem;
import cs5500.project.spring.data.Submission;
import org.bson.Document;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that performs operations on mongo for the backend
 */
public class MongoOperation {

    /**
     * @param report the Report object to insert
     * @return the id of saved object
     */
    public static void saveReport(Report report) {

        DB db;
        DBCollection collection;
        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            db = mongoClient.getDB("dd");
            collection = db.getCollection("reports");
            collection.insert(getReportDocument(report));
        }
     }


    /**
     * Gets all the files of an assignment
     * @param assignmentId the assignment id
     * @return a list of submissions
     */
     public static List<Submission> getSubmissions(Integer assignmentId) {
         List<Submission> l = new ArrayList<>();
         BasicDBObject searchQuery;
         DBCursor cursor;
         try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
             DB database = mongoClient.getDB("dd");
             DBCollection collection = database.getCollection("submissions");
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

     private static BasicDBObject getReportDocument(Report report) {
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
}
