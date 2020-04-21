/*
Given a string s containing only a and b, find longest substring of s such that s does not contain more than two contiguous occurrences of a and b.

 */

public class LongestSubstringWithoutThreeContLetters {
    static String[] testStrings = new String[] {"aabbaaaaabb", "aabbaabbaabbaa", "aaabaaa", "a", "", "abbaabbaaabbaaa", "aaabb", "aabbaabbbaabbaa", "aaaaaaaaaaaaaaa", "abbaaabbaabb", "babba",
        "bbbbbbbbbbbaaaaaaaaaabbabb"};
    static String[] expectedResult = new String[] {"aabbaa", "aabbaabbaabbaa", "aabaa", "a", "", "abbaabbaa", "aabb", "aabbaabb", "aa", "aabbaabb", "babba",
        "aabbabb"};

    public static void main(String[] args) {
        int passedTest = 0;
        for(int i = 0; i < testStrings.length; i++) {
            String test = testStrings[i];
            String expected = expectedResult[i];
            System.out.println("Test " + i + ": " + "Testing: " + test + " Expected result: " + expected);
            String result = validSubstring(test);
            boolean isPassed = result.equals(expected);
            System.out.println("Result: " + result + " " + isPassed + "\n");
            if(isPassed)
                passedTest++;
        }
        if(passedTest == testStrings.length)
            System.out.println("All test passed");
    }

    private static String validSubstring(String s) {
        String res = "";
        if (s.length() == 0)
            return res;
        int count = 0;
        int start = 0;
        int end = 0;
        char c = s.charAt(0);
        while(end < s.length()) {
            if(s.charAt(end) == c) {
                count++;
            } else {
                count = 1;
                c = s.charAt(end);
            }
            if(end - start > res.length())
                res = s.substring(start, end);

            if(count > 2) {
                start = end - 1;
                count = 1;
            } else {
                end++;
            }
        }

        if(end - start > res.length())
            res = s.substring(start, end);

        return res;
    }
}
