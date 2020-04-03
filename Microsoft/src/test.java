import java.io.*;
import java.util.*;

class MyCode {
    public static void main (String[] args) {
        System.out.println("Hello Java");
        System.out.println(LongestSubStringSwap("aababbbbaaab"));
    }

    public static int LongestSubStringSwap(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        char[] letters = s.toCharArray();
        for(char c : letters) {
            if(!freq.containsKey(c)) {
                freq.put(c, 0);
            }
            freq.put(c, freq.get(c) + 1);
        }
        int max = 0;
        int start = 0;
        int index = 0;
        int next = 0;
        while(start < letters.length) {
            char c = letters[start];
            int sameLetter = 0;
            int count = 0;
            while(count < 2 && index < letters.length) {
                if(letters[start] == letters[index]) {
                    index++;
                    sameLetter++;
                } else {
                    if(count == 0) {
                        next = index;
                        index++;
                    }
                    count++;
                }
            }
            int currentMax = freq.get(c);
            if(sameLetter < currentMax) {
                max = index != letters.length ? Math.max(index - start, max) : Math.max(index - start + 1, max);
            } else {
                max = index != letters.length ? Math.max(max, index - start - 1) : Math.max(max, index - start);
            }
            if(index >= letters.length) {
                break;
            }
            start = next;
            index = start;
        }
        return max;
    }
}