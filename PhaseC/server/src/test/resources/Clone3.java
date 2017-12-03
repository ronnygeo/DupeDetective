package com.example;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Some comments
 */
public class Clone3 extends Clone1{

    // Default constructor
    public Clone3() {
        super();
    }

    // Main Method
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("Ronny");
//        assert str.toString().equals("Ronny");
        String newStr = Stream.of(str.toString().toCharArray()).map(s -> s.hashCode() + 1).collect(Collectors.toList()).toString();
        System.out.println("Updated string: " + newStr);
    }
}