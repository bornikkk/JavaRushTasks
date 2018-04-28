package com.javarush.task.task20.task2026;

import java.util.Arrays;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        System.out.println(a);
        byte[][] b = new byte[5][5];
        System.out.println(b);
        for (int i=0; i<a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[i][j] = a[i][j];
            }
        }
        for (int i = 0; i<5; i++){
            b[4][i] = 0;
        }
        for (int i =0; i<5; i++){
            b[i][4] = 0;
        }
        for (int i=0; i<b.length-1; i++){
            for (int j=0; j<b[i].length-1; j++){
                if(b[i][j]>b[i][j+1] && b[i][j]>b[i+1][j]) count++;
            }
        }
        return count;
    }
}
