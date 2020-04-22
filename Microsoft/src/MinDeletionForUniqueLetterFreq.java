/*
Given a string s consisting of n lowercase letters, you have to delete the minimum number of characters from s so that every letter in s appears a unique number of times.
We only care about the occurrences of letters that appear at least once in result.
 */

import java.util.HashMap;
import java.util.HashSet;

public class MinDeletionForUniqueLetterFreq {
    static String[] testStrings = new String[] {"eeeeffff", "aabbffddeaee", "llll", "example", "", "a", "abc", "aaabbbccc", "aaabbbcc", "aaaaaabbbbbccccddddeeeeee", "abcdefghijkl"};
    static int[] expectedResult = new int[] {1,6,0,4,0,0,2,3,2,5,11};

    public static void main(String[] args) {
        int passedTest = 0;
        for(int i = 0; i < testStrings.length; i++) {
            String test = testStrings[i];
            int expected = expectedResult[i];
            System.out.println("Test " + i + ": " + "Testing: " + test + " Expected result: " + expected);
            int result = getMinDeletion(test);
            boolean isPassed = result == expected;
            System.out.println("Result: " + result + " " + isPassed + "\n");
            if(isPassed)
                passedTest++;
        }
        if(passedTest == testStrings.length)
            System.out.println("All test passed!");
    }

    private static int getMinDeletion(String s) {
        int[] letterCounts = new int[26];
        int[] freq = new int[s.length() + 1];
        for(int i = 0; i < s.length(); i++) {
            int key = s.charAt(i) - 'a';
            int amount = letterCounts[key];
            letterCounts[key]++;
            freq[amount]--;
            freq[amount + 1]++;
        }

        int count = 0;
        for(int i = freq.length - 1; i >= 0; i--) {
            if(freq[i] > 1) {
                count += freq[i] - 1;
                if(i > 0) {
                    freq[i - 1] += freq[i] - 1;
                }
                freq[i] = 1;
            }
        }
        return count;
    }

}

/*
this is easy approach, believe to be o(N^2)
go through each of the characters in the string which is O(n) then each character frequency,
requires to  check n-- until 0 if we can add it to set. Not entirely sure.

int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(char key : map.keySet()) {
            int n = map.get(key);
            while(n > 0 && !seen.add(n)) {
                n--;
                count++;
            }
        }
        return count;

 */