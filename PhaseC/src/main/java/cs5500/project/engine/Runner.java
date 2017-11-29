package cs5500.project.engine;

import cs5500.project.data.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main driver for the PDetection
 */
public class Runner {
    private static Map<Integer, Float> weights;

    /**
     * Read the weights from file into a hashmap
     */
    private static void readWeights() {
        //TODO: Read weights from file
        weights = new HashMap<>();
        weights.put(Model.ASTLoop.getValue(), 0.25f);
        weights.put(Model.ASTMethod.getValue(), 0.25f);
        weights.put(Model.ASTStructure.getValue(), 0.5f);
        weights.put(Model.WINNOWING.getValue(), 0.00f);
    }

    /**
     * Start analysis of documents
     * @param assignmentId assignment id to analyze
     */
    public static void analyze(String assignmentId) {
        readWeights();
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
                Boolean md5Result = md5.executeStrategy(code1, code2).get(0).getScore() == 1;
                report1.setMd5Result(md5Result);
                report2.setMd5Result(md5Result);
                report1.addModel(getModelReport(code1, code2, Model.ASTStructure.getValue()));
                report1.addModel(getModelReport(code1, code2, Model.ASTMethod.getValue()));
                report1.addModel(getModelReport(code1, code2, Model.ASTLoop.getValue()));
                report1.computeScore(weights);
                report2.addModel(getModelReport(code2, code1, Model.ASTStructure.getValue()));
                report2.addModel(getModelReport(code2, code1, Model.ASTMethod.getValue()));
                report2.addModel(getModelReport(code2, code1, Model.ASTLoop.getValue()));
                report2.computeScore(weights);
                System.out.println("Saving to mongo.");
                mongo.saveReport(report1);
                mongo.saveReport(report2);
            }
        }
        mongo.updateAnalyzedAssignment(assignmentId);
    }

    /**
     * Get the Report for the Structure
     * @param code1 first code to compare
     * @param code2 second code to compare
     * @param model model Id
     */
    private static ModelReport getModelReport(String code1, String code2, Integer model) {
        ModelReport mr = new ModelReport(model);
        PDContext context = getContext(model);
        mr.setLines(context.executeStrategy(code1, code2));
        mr.computeScore();
        System.out.println(model + " score: " + mr.getScore());
        return mr;
    }


    /**
     * @param model the model id
     * @return a PD strategy for this model
     */
    public static PDContext getContext(Integer model) {
        if (model == Model.ASTStructure.getValue()) {
            return new PDContext(new ASTStructureStrategy());
        } else if (model == Model.ASTMethod.getValue()) {
            return new PDContext(new ASTMethodStrategy());
        } else if (model == Model.ASTLoop.getValue()) {
            return new PDContext(new ASTLoopStrategy());
        } else {
            return new PDContext(new MD5Strategy());
        }
    }

    /**
     * Main method to test run
     * @param args args for main
     */
    public static void main(String[] args) {
        analyze("5a148985c6bb701ff50f849e");
    }

}
