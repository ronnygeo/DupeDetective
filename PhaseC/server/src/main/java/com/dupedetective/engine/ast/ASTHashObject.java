package com.dupedetective.engine.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * ASTHashObject that stores the data about a node in the tree
 */
public class ASTHashObject {

    /**
     * @param name identifier name of node
     * @param type type of node
     * @param offset offset of node
     * @param length length of node
     */
    public ASTHashObject(String name, Integer type, Integer offset, Integer length) {
        this.name = name;
        this.type = type;
        this.offset = offset;
        this.length = length;
        this.hash = 0l;
        this.nodes = new ArrayList<>();
    }

    /**
     * @param name identifier name of node
     * @param type type of node
     * @param offset offset of node
     * @param length length of node
     * @param hash hash of node
     */
    public ASTHashObject(String name, Integer type, Integer offset, Integer length, Long hash) {
        this.name = name;
        this.type = type;
        this.offset = offset != null? offset: 0;
        this.length = length != null? length: 0;
        this.hash = hash != null? hash: 0;
        this.nodes = new ArrayList<>();
    }

    /**
     * Default Constructor
     */
    public ASTHashObject() {
        this.nodes = new ArrayList<>();
    }

    /**
     * @return the name of the Node
     */
    public String getName() {
        return name;
    }

    /**
     * @param name  the name of the Node
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type of the node
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type  the type of the node
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return the starting position of the node in the file
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * @param offset the starting position of the node in the file
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * @return the length of the node in the file
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @param length the length of the node in the file
     */
    public void setLength(Integer length) {
        this.length = length;
    }


    /**
     * @return the computed hash of the node
     */
    public Long getHash() {
        return hash;
    }

    /**
     * @param hash  the computed hash of the node
     */
    public void setHash(Long hash) {
        this.hash = hash;
    }

    /**
     * @param hash add this hash to node hash
     */
    public void addToHash(Integer hash) {
        this.hash += hash;
    }

    /**
     * @param hash add this hash to node hash
     */
    public void addToHash(Long hash) {
        this.hash += hash;
    }


    /**
     * @return the list of nodes that lives in this node
     */
    public List<ASTHashObject> getNodes() {
        return nodes;
    }

    /**
     * @param nodes the list of nodes that lives in this node
     */
    public void setNodes(List<ASTHashObject> nodes) {
        this.nodes = nodes;
    }

    /**
     * @param node add this node to list of nodes
     */
    public void addNode(ASTHashObject node) {
        if (this.name != null)
        this.nodes.add(node);
    }

    private List<ASTHashObject> nodes;
    private String name;
    private Integer type;
    private Integer offset;
    private Integer length;
    private Long hash;
}
