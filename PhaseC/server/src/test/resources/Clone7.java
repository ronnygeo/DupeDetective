package com.example;

public class Main {

    public static void main(String[] args) {
        int i;
        i = 0;
        int[] items = {1,2,3};
        Boolean status = false;
        System.out.println(status instanceof Boolean);
        ++i;
        int k = 10;
        k += 10;
        int p = i + k;
        System.out.println("Hellooo World!");
        for (int item: items) {
            System.out.println(item);
        }
        int t = 0;
        while(t < 10) {
            System.out.println(t);
            t++;
        }
    }

}
