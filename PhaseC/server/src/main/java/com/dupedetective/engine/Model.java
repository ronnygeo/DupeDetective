package com.dupedetective.engine;

/**
 * An enum with the different models
 */
public enum Model {
    ASTStructure(1), ASTLoop(2), ASTMethod(3), MD5(4), WINNOWING(5);

    private final int id;
    Model(int i) {
        this.id = i;
    }
    public int getValue() { return id; }
}
