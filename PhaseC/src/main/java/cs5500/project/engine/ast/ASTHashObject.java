package cs5500.project.engine.ast;

import com.google.common.hash.HashCode;

import java.util.ArrayList;
import java.util.List;

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
    public ASTHashObject(String name, Integer type, Integer offset, Integer length, long hash) {
        this.name = name;
        this.type = type;
        this.offset = offset;
        this.length = length;
        this.hash = hash;
        this.nodes = new ArrayList<>();
    }

    /**
     * Default Constructor
     */
    public ASTHashObject() {}

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return
     */
    public Integer getoffset() {
        return offset;
    }

    /**
     * @param offset
     */
    public void setoffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * @return
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @param length
     */
    public void setLength(Integer length) {
        this.length = length;
    }


    public Long getHash() {
        return hash;
    }

    public void setHash(Long hash) {
        this.hash = hash;
    }

    public void addToHash(HashCode hash) {
        this.hash += hash.asLong();
    }

    public void addToHash(Integer hash) {
        this.hash += hash;
    }

    public void addToHash(Long hash) {
        this.hash += hash;
    }

    private String name;
    private Integer type;
    private Integer offset;
    private Integer length;
    private Long hash;

    public List<ASTHashObject> getNodes() {
        return nodes;
    }

    public void setNodes(List<ASTHashObject> nodes) {
        this.nodes = nodes;
    }

    public void addNode(ASTHashObject node) {
        if (this.name != null)
        this.nodes.add(node);
    }

    private List<ASTHashObject> nodes;
}
