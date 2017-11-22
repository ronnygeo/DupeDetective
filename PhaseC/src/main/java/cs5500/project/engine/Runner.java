package cs5500.project.engine;

import cs5500.project.db.MongoOperation;
import cs5500.project.db.Report;
import cs5500.project.db.Submission;

import java.util.List;

/**
 * Main driver for the PDetection
 */
public class Runner {

    /**
     * Start analysis of documents
     * @param assignmentId assignment id to analyze
     */
    public static void analyze(String assignmentId) {
        MongoOperation mongo = new MongoOperation();
        List<Submission> submissions = mongo.getSubmissions(assignmentId);
        // Iterate through all the files and compare each one side by side for the given assignment
        for (int i = 0; i < submissions.size(); i++) {
            for (int j = i + 1; j < submissions.size(); j++) {
                System.out.println("Comparing submission " + i + " with " + j);
                String code1 = submissions.get(i).getFilecontent();
                String code2 = submissions.get(j).getFilecontent();

                Report report1 = new Report(submissions.get(i).getId(), submissions.get(i).getId(), submissions.get(j).getId());
                Report report2 = new Report(submissions.get(j).getId(), submissions.get(j).getId(), submissions.get(i).getId());

                PDContext md5 = new PDContext(new MD5Strategy());
                PDContext contextStructure = new PDContext(new ASTStructureStrategy());
                PDContext methodStructure = new PDContext(new ASTMethodStrategy());
                PDContext loopStructure = new PDContext(new ASTLoopStrategy());

                report1.addLines(contextStructure.executeStrategy(code1, code2));
                report1.addLines(methodStructure.executeStrategy(code1, code2));
                report1.addLines(loopStructure.executeStrategy(code1, code2));
                report1.addLines(md5.executeStrategy(code1, code2));

                report2.addLines(contextStructure.executeStrategy(code1, code2));
                report2.addLines(methodStructure.executeStrategy(code1, code2));
                report2.addLines(loopStructure.executeStrategy(code1, code2));
                report2.addLines(md5.executeStrategy(code1, code2));

                mongo.saveReport(report1);
                mongo.saveReport(report2);
            }
        }
        //TODO: Once completed set analyzed flag to true for assignment id
    }
}
