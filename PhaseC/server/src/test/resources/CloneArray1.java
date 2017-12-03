package com.example;

public class Main {

    public static void main(String[] args) {
        int t = 0;
        while(t < 10) {
            int i[] = new int[3];
            i[0] = 0;
            i[1] = 1;
            i[2] = i[0] + i[1];
            System.out.println(i[2] + " some numbr!");
            t++;
            break;
        }
    }

}
