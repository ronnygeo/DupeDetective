package cs5500.project.engine.md5;

import java.io.File;
import java.io.IOException;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

public class MD5Parser {

    public String getMD5File(String filename) {
        try {
            HashCode hash = com.google.common.io.Files.hash(new File(filename), Hashing.md5());
            return hash.toString();
        } catch (IOException io) {
            return null;
        }
    }
}
