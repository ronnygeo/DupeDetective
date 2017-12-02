package engine.md5.tests;

import com.dupedetective.engine.md5.MD5Generator;
import engine.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the MD5 checksum class
 */
public class Md5Tests {
    @Test
    public void testMd5Value() {
        String file = this.getClass().getResource("/test.txt").getFile();
        assertEquals("cba8589898ec23aab33e2eba90bad873", MD5Generator.getMD5File(file));
    }

    @Test
    public void testMd5SimilarFiles() {
        String file1 =  this.getClass().getResource("/test.txt").getFile();
        String file2 =  this.getClass().getResource("/sameTest.txt").getFile();
        assertEquals(MD5Generator.getMD5File(file1), MD5Generator.getMD5File(file2));
    }

    @Test
    public void testMd5DifferentFiles() {
        String file1 =  this.getClass().getResource("/test.txt").getFile();
        String file2 =  this.getClass().getResource("/diffTest.txt").getFile();
        assertNotEquals(MD5Generator.getMD5File(file1), MD5Generator.getMD5File(file2));
    }

    @Test
    public void testMd5ValueString() {
        String file = "Hi, Im the test file to check my MD5. I have a twin.";
        assertEquals("cba8589898ec23aab33e2eba90bad873", MD5Generator.getMD5String(file));
    }

    @Test
    public void testMd5SameString() {
        String file1 = "Hi, Im the test file to check my MD5. I have a twin.";
        String file2 = "Hi, Im the test file to check my MD5. I have a twin.";
        assertEquals(MD5Generator.getMD5String(file1), MD5Generator.getMD5String(file2));
    }

    @Test
    public void testMd5DiffString() {
        String file1 = "Hi, Im the test file to check my MD5. I have a twin.";
        String file2 = "Hi, Im a different test file to check my MD5.";
        assertNotEquals(MD5Generator.getMD5String(file1), MD5Generator.getMD5String(file2));
    }

    @Test
    public void testSameFiles() {
        TestUtils util = new TestUtils();
        String testCode = util.readFile("Clone1.java");
        assertTrue(MD5Generator.getMD5String(testCode).equals(MD5Generator.getMD5String(testCode)));
    }
}
