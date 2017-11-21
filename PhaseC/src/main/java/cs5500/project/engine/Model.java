package cs5500.project.engine;

/**
 * An enum with the different models
 */
public enum Model {
    ASTStructure(1), ASTLoop(2), ASTMethod(3);

    private final int id;
    Model(int i) {
        this.id = i;
    }
    public int getValue() { return id; }
}
