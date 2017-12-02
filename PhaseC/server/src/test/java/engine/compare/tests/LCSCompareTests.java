package engine.compare.tests;

import cs5500.project.engine.ast.ASTHashObject;
import cs5500.project.engine.ast.ASTUtilities;
import cs5500.project.engine.ast.compare.LCSCompare;
import cs5500.project.engine.ast.compare.LCSCompareMode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LCSCompareTests {
    @Test
    public void basicLCSCompare() {
        LCSCompare lcsc = new LCSCompare(LCSCompareMode.HASH);
        ASTHashObject ao = new ASTHashObject();
        ASTHashObject ao1 = new ASTHashObject();
        ao1.setHash(1000L);
        ASTHashObject ao2 = new ASTHashObject();
        ao2.setHash(1000L);
        List<ASTHashObject> lao = new ArrayList<>();
        lao.add(ao1);
        lao.add(ao2);
        ao.setNodes(lao);
        assertEquals(2, lcsc.compare(ao.getNodes(), ao.getNodes()).size());
    }

    @Test
    public void ASTCompareHash() {
        LCSCompare lcsc = new LCSCompare(LCSCompareMode.HASH);
        ASTHashObject ao1 = new ASTHashObject();
        ao1.setHash(1000L);
        assertEquals(lcsc.getHash(ao1), lcsc.getHash(ao1));
    }

    @Test
    public void ASTCompareType() {
        LCSCompare lcsc = new LCSCompare(LCSCompareMode.TYPE);
        ASTHashObject ao1 = new ASTHashObject();
        ao1.setHash(1000L);
        assertEquals(lcsc.getHash(ao1), lcsc.getHash(ao1));
    }

    @Test
    public void ASTUtilsTests() {
        ASTUtilities astul = new ASTUtilities();
        assertEquals("cs5500.project.engine.ast.ASTUtilities", astul.getClass().getName());
    }
}
