package cs5500.project.engine.md5;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class MD5Generator {

    public static String getMD5File(String filename) {
        try {
            HashCode hash = com.google.common.io.Files.hash(new File(filename), Hashing.md5());
            return hash.toString();
        } catch (IOException io) {
            return null;
        }
    }

    public static String getMD5String(String text) {
        HashFunction hf = Hashing.md5();
        HashCode hc = hf.newHasher()
                        .putString(text, Charsets.UTF_8)
                        .hash();
        return hc.toString();
    }
}
