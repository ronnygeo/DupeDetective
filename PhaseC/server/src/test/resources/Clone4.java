package com.example;

import com.example.Clone1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Some comments
 */
public class Clone4 extends Clone1{

    // Default constructor
    public Clone4() {
        super();
    }

    /**
     * Class to update hash
     */
    private static class UpdateHash() {
        // Update hashcode of the string
        public static String update(String s) {
            return Stream.of(str.toString().toCharArray()).map(s -> s.hashCode() + 1).collect(Collectors.toList()).toString();
        }
    }

    // Main Method
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("Ronny");
//        assert str.toString().equals("Ronny");
        String newStr = this.UpdateHash.update(str.toString());
        System.out.println("Updated string: " + newStr);
    }
}