package cs5500.project.db;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import cs5500.project.spring.data.Report;
import cs5500.project.spring.data.ReportItem;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that performs operations on mongo for the backend
 */
public class MongoOperation {

    /**
     * @param report
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

     private static BasicDBObject getReportDocument(Report report) {
         BasicDBObject document = new BasicDBObject();
         document.put("refFileId", report.getRefFileId());
         document.put("similarFileId", report.getSimilarFileId());

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
