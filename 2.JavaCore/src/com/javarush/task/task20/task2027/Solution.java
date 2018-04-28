package com.javarush.task.task20.task2027;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> listRes = detectAllWords(crossword, "home", "same");
        for (int i=0; i<listRes.size(); i++){
            System.out.println(listRes.get(i).toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> word = new ArrayList<>();
        ArrayList<String> wordR = new ArrayList<>();

        for (int i=0; i<words.length; i++){
            wordR.add(words[i]);
        }

        ArrayList<String> cross = new ArrayList<>();
        for (int i=0; i<crossword.length; i++){
            String str = "";
            for (int j=0; j<crossword[i].length; j++){
                str = str + (char)crossword[i][j];
            }
            cross.add(str);
        }

        for (int i=0; i<cross.size(); i ++){
            for (int j=0; j<wordR.size(); j++){
                int index = cross.get(i).indexOf(wordR.get(j));
                if (index != -1){
                    word.add(0, new Word(wordR.get(j)));
                    word.get(0).setStartPoint(index,i);
                    word.get(0).setEndPoint(index+wordR.get(j).length()-1, i);
                }
            }
        }

        /*
        for (int i=0; i<wordR.size(); i++){
            word.add(new Word(wordR.get(i)));
            word.get(i).setStartPoint(i,i);
            word.get(i).setEndPoint(i+10, i+10);
        }*/

        return word;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
