package com.dupedetective.engine.md5;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.io.File;
import java.io.IOException;

/**
 * Class that generates the MD5 checksum for a string or file content
 */
public class MD5Generator {

    /**
     * @param filename the name of the file to hash
     * @return the checksum of the given file contents
     */
    public static String getMD5File(String filename) {
        try {
            if (filename == null || filename.equals("")) return "0";
            HashCode hash = com.google.common.io.Files.hash(new File(filename), Hashing.md5());
            return hash.toString();
        } catch (IOException io) {
            return "0";
        }
    }

    /**
     * @param text the text to compute hash
     * @return the checksum of the given string
     */
    public static String getMD5String(String text) {
        if (text == null || text.equals("")) return "0";
        HashFunction hf = Hashing.md5();
        HashCode hc = hf.newHasher()
                        .putString(text, Charsets.UTF_8)
                        .hash();
        return hc.toString();
    }
}
