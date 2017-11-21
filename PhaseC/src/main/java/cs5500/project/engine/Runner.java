package cs5500.project.engine;

import cs5500.project.db.MongoOperation;
import cs5500.project.spring.data.Report;
import cs5500.project.spring.data.Submission;

import java.util.List;
import java.util.stream.Collectors;

import static cs5500.project.db.MongoOperation.getSubmissions;

/**
 * Main driver for the PDetection
 */
public class Runner {

    /**
     * Start analysis of documents
     */
    public static void analyze(Integer assignmentId) {
        List<Submission> submissions = getSubmissions(assignmentId);
        // Iterate through all the files and compare each one side by side for the given assignment
        for (int i = 0; i < submissions.size(); i++) {
            for (int j = i + 1; j < submissions.size(); j++) {
                System.out.println(i + " " + j);
                String code1 = submissions.get(i).getFilecontent();
                String code2 = submissions.get(j).getFilecontent();

                Report report1 = new Report(submissions.get(i).getId(), submissions.get(i).getId(), submissions.get(j).getId());
                Report report2 = new Report(submissions.get(j).getId(), submissions.get(j).getId(), submissions.get(i).getId());
//        PDContext md5 = new PDContext(new MD5Strategy());
                PDContext contextStructure = new PDContext(new ASTStructureStrategy());
                PDContext methodStructure = new PDContext(new ASTMethodStrategy());
                PDContext loopStructure = new PDContext(new ASTLoopStrategy());

//        System.out.println("MD5: " + md5.executeStrategy(code1, code2));

                report1.addItems(contextStructure.executeStrategy(code1, code2));
                report1.addItems(methodStructure.executeStrategy(code1, code2));
                report1.addItems(loopStructure.executeStrategy(code1, code2));

                report2.addItems(contextStructure.executeStrategy(code1, code2));
                report2.addItems(methodStructure.executeStrategy(code1, code2));
                report2.addItems(loopStructure.executeStrategy(code1, code2));

                MongoOperation.saveReport(report1);
                MongoOperation.saveReport(report2);
            }
        }
    }

    public static void main(String[] args) {
        analyze(1);
    }
}
