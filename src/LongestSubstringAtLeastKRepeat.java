/*
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubstringAtLeastKRepeat {
    static String[] testStrings = new String[] {"ababacb", "ababbc"};
    static int[] K = new int[] {3, 2};
    static int[] expectedResult = new int[] {0, 5};


    public static void main(String[] args) {
        int passedTest = 0;
        for(int i = 0; i < testStrings.length; i++) {
            String test = testStrings[i];
            int k = K[i];
            int expected = expectedResult[i];
            System.out.println("Test " + i + ": " + "Testing: " + test + " Expected result: " + expected);
            int result = longestSubstring(test, k);
            boolean isPassed = result == expected;
            System.out.println("Result: " + result + " " + isPassed + "\n");
            if(isPassed)
                passedTest++;
        }
        if(passedTest == testStrings.length)
            System.out.println("All test passed!");
    }

    public static int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k == 0)
            return 0;
        int max = 0;
        int[] count = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k)
                pos.add(i);
        }
        if (pos.size() == 0)
            return s.length();
        pos.add(0, -1);
        pos.add(s.length());
        for (int i = 1; i < pos.size(); i++) {
            int start = pos.get(i-1) + 1;
            int end = pos.get(i);
            int next = longestSubstring(s.substring(start, end), k);
            res = Math.max(res, next);
        }
        return res;
    }
}
