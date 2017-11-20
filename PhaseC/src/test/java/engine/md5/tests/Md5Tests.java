package engine.md5.tests;

import cs5500.project.engine.md5.MD5Generator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests for the MD5 checksum class
 */
public class Md5Tests {

    ClassLoader classLoader = getClass().getClassLoader();

    @Test
    public void testMd5Value() {
        String file = classLoader.getResource("engine/md5/tests/test.txt").getFile();
        MD5Generator md5 = new MD5Generator();
        assertEquals("cba8589898ec23aab33e2eba90bad873", md5.getMD5File(file));
    }

    @Test
    public void testMd5SimilarFiles() {
        String file1 = classLoader.getResource("engine/md5/tests/test.txt").getFile();
        String file2 = classLoader.getResource("engine/md5/tests/sameTest.txt").getFile();
        MD5Generator md5 = new MD5Generator();
        assertEquals(md5.getMD5File(file1), md5.getMD5File(file2));
    }

    @Test
    public void testMd5DifferentFiles() {
        String file1 = classLoader.getResource("engine/md5/tests/test.txt").getFile();
        String file2 = classLoader.getResource("engine/md5/tests/diffTest.txt").getFile();
        MD5Generator md5 = new MD5Generator();
        assertNotEquals(md5.getMD5File(file1), md5.getMD5File(file2));
    }

    @Test
    public void testMd5ValueString() {
        String file = "Hi, Im the test file to check my MD5. I have a twin.";
        MD5Generator md5 = new MD5Generator();
        assertEquals("cba8589898ec23aab33e2eba90bad873", md5.getMD5String(file));
    }

    @Test
    public void testMd5SameString() {
        String file1 = "Hi, Im the test file to check my MD5. I have a twin.";
        String file2 = "Hi, Im the test file to check my MD5. I have a twin.";
        MD5Generator md5 = new MD5Generator();
        assertEquals(md5.getMD5String(file1), md5.getMD5String(file2));
    }

    @Test
    public void testMd5DiffString() {
        String file1 = "Hi, Im the test file to check my MD5. I have a twin.";
        String file2 = "Hi, Im a different test file to check my MD5.";
        MD5Generator md5 = new MD5Generator();
        assertNotEquals(md5.getMD5String(file1), md5.getMD5String(file2));
    }

}
