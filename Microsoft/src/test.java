import java.io.*;
import java.util.*;

class MyCode {
    public static void main (String[] args) {
        System.out.println("Hello Java");
        System.out.println(LongestSubStringSwap("aaabaaaba") + " Should be: 7");
        System.out.println(LongestSubStringSwap("aababbbbaaab") + " Should be: 6");
        System.out.println(LongestSubStringSwap("aaddbb") + " Should be: 2");
        System.out.println(LongestSubStringSwap("cbbde") + " Should be: 2");
        System.out.println(LongestSubStringSwap("abcdefa") + " Should be: 2");
        System.out.println(LongestSubStringSwap("aaa") + " Should be: 3");
        System.out.println(LongestSubStringSwap("aaaadadd") + " Should be: 5");
        System.out.println(LongestSubStringSwap("aadadd") + " Should be: 3");
        System.out.println(LongestSubStringSwap("aadaddd") + " Should be: 4");
        System.out.println(LongestSubStringSwap("baababbb") + " Should be: 5");
        System.out.println(LongestSubStringSwap("asdfasdfaaa") + " Should be: 4");
        System.out.println(LongestSubStringSwap("abc") + " Should be: 1");
        System.out.println(LongestSubStringSwap("aaaabaaa") + " Should be: 7");
        System.out.println(LongestSubStringSwap("") + " Should be: 0");
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

            // if there is less same letter than current letters max, then i can add 1 to the count
            // if they are the same, means no swap is needed.
            // same letter is never greater than current max b/c current max is already precalculated.
            if(sameLetter < currentMax) {
                max = Math.max(sameLetter + 1, max);
            } else if (sameLetter == currentMax) {
                max = Math.max(sameLetter, max);
            }
            start = index == letters.length ? index : next;
            index = start;
        }
        return max;
    }
}