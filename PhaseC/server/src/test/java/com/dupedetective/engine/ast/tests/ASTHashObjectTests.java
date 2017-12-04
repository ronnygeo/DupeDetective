package com.dupedetective.engine.ast.tests;

import com.dupedetective.engine.ast.ASTHashObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ASTHashObjectTests {
    private ASTHashObject aho;

    @Before
    public void setup() {
        aho = new ASTHashObject();
    }

    @Test
    public void setNameTests() {
        aho.setName("test node");
        assertEquals("test node", aho.getName());
    }

    @Test
    public void setTypeTests() {
        aho.setType(1);
        assertEquals(1, aho.getType(), 0.01);
    }

    @Test
    public void setLengthTests() {
        aho.setLength(1);
        assertEquals(1, aho.getLength(), 0.01);
    }

    @Test
    public void setOffsetTests() {
        aho.setOffset(1);
        assertEquals(1, aho.getOffset(), 0.01);
    }

    @Test
    public void setHashTests() {
        aho.setHash(1L);
        assertEquals(1L, aho.getHash(), 0.01);
    }

    @Test
    public void addIntHashTests() {
        aho.setHash(1L);
        aho.addToHash(1);
        assertEquals(2, aho.getHash(), 0.01);
    }

    @Test
    public void addLongHashTests() {
        aho.setHash(1L);
        aho.addToHash(1L);
        assertEquals(2, aho.getHash(), 0.01);
    }

    @Test
    public void addHCHashTests() {
        aho.setHash(1L);
        aho.addToHash("1".hashCode());
        assertEquals(50, aho.getHash(), 0.01);
    }

    @Test
    public void setNodesTests() {
        List<ASTHashObject> l = new ArrayList<>();
        l.add(new ASTHashObject());
        aho.setNodes(l);
        assertEquals(l, aho.getNodes());
    }
}
