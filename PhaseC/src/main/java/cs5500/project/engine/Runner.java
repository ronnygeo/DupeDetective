package cs5500.project.engine;

/**
 * Main driver for the PDetection
 */
public class Runner {

    /**
     * Start analysis of documents
     */
    public static void analyze() {
        //TODO: Iterate through all the files and compare each one side by side
        String code1 = "\n public class A {" +
                "\npublic String parse(String txt) { \n " +
                "for(int i=0; i<7;i++) {i = j; new System(); }} \n} ";
        String code2 = "\n public class A {" +
                "\npublic String parse(String txt) { \n " +
                "int i=0; while(i<7) {i = j; new System(); i++;}} \n} ";

        //TODO: Initialize new report object
        //TODO: Add all report Items to the report object
        PDContext md5 = new PDContext(new MD5Strategy());
        PDContext contextStructure = new PDContext(new ASTStructureStrategy());
        PDContext methodStructure = new PDContext(new ASTMethodStrategy());
        PDContext loopStructure = new PDContext(new ASTLoopStrategy());

        //TODO: Save the report object


        System.out.println("MD5: " + md5.executeStrategy(code1, code2));
        System.out.println("Structure: " + contextStructure.executeStrategy(code1, code2));
        System.out.println("Method: " + methodStructure.executeStrategy(code1, code2));
        System.out.println("Loop: " + loopStructure.executeStrategy(code1, code2));
    }

    public static void main(String[] args) {
        analyze();
    }
}
