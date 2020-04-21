/*
Given a string S consisting of N letters a and b. In one move you can replace one letter by the other (a by b or b by a).

Write a function solution that given such a string S, returns the minimum number of moves required to obtain a string containing no instances of three identical consecutive letters.
 */

public class MinMovesWithoutThreeConsecutiveLetters {
    static String[] testStrings = new String[] {"baaaaa", "baaabbaabbba", "baabab", "aaaaaa", "baaaaaa", "baaaab", "bbaabbaabbabab", "baaaaaab", "aaabbbabaaab"};
    static int[] expectedResult = new int[] {1, 2, 0, 2, 2, 1, 0, 2, 3};

    public static void main(String[] args) {
        int passedTest = 0;
        for(int i = 0; i < testStrings.length; i++) {
            String test = testStrings[i];
            int expected = expectedResult[i];
            System.out.println("Test " + i + ": " + "Testing: " + test + " Expected result: " + expected);
            int result = findMinMoves(test);
            boolean isPassed = result == expected;
            System.out.println("Result: " + result + " " + isPassed + "\n");
            if(isPassed)
                passedTest++;
        }
        if(passedTest == testStrings.length)
            System.out.println("All test passed!");
    }

    public static int findMinMoves(String word) {
        int moves = 0;
        if(word.length() <= 2)
            return moves;

        char[] arr = word.toCharArray();
        char check = arr[0];
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            if(cur == check) {
                count++;
            } else {
                moves += count / 3;
                count = 1;
                check = cur;
            }
        }
        if(count > 2) {
            moves += count / 3;
        }
        return moves;
    }
}
