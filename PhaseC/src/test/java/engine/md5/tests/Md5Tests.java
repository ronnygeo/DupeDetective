package engine.md5.tests;

import cs5500.project.engine.md5.MD5Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Md5Tests {

    ClassLoader classLoader = getClass().getClassLoader();

    @Test
    public void testMd5Value() {
        String file = classLoader.getResource("test.txt").getFile();
        MD5Parser md5 = new MD5Parser();
        assertEquals("cba8589898ec23aab33e2eba90bad873", md5.getMD5File(file));
    }

    @Test
    public void testMd5SimilarFiles() {
        String file1 = classLoader.getResource("test.txt").getFile();
        String file2 = classLoader.getResource("sameTest.txt").getFile();
        MD5Parser md5 = new MD5Parser();
        assertEquals(md5.getMD5File(file1), md5.getMD5File(file2));
    }

    @Test
    public void testMd5DifferentFiles() {
        String file1 = classLoader.getResource("test.txt").getFile();
        String file2 = classLoader.getResource("diffTest.txt").getFile();
        MD5Parser md5 = new MD5Parser();
        assertNotEquals(md5.getMD5File(file1), md5.getMD5File(file2));
    }

    @Test
    public void testMd5ValueString() {
        String file = "Hi, Im the test file to check my MD5. I have a twin.";
        MD5Parser md5 = new MD5Parser();
        assertEquals("cba8589898ec23aab33e2eba90bad873", md5.getMD5String(file));
    }

    @Test
    public void testMd5SameString() {
        String file1 = "Hi, Im the test file to check my MD5. I have a twin.";
        String file2 = "Hi, Im the test file to check my MD5. I have a twin.";
        MD5Parser md5 = new MD5Parser();
        assertEquals(md5.getMD5String(file1), md5.getMD5String(file2));
    }

    @Test
    public void testMd5DiffString() {
        String file1 = "Hi, Im the test file to check my MD5. I have a twin.";
        String file2 = "Hi, Im a different test file to check my MD5.";
        MD5Parser md5 = new MD5Parser();
        assertNotEquals(md5.getMD5String(file1), md5.getMD5String(file2));
    }

}
