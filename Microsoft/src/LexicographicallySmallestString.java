/*
Lexicographically smallest string formed by removing at most one character.
 */

public class LexicographicallySmallestString {
    static String[] testStrings = new String[] {"abczd", "abcde", "cba", "a", "abzdz", "edcba", "abde", "abed", "ab", "ba"};
    static String[] expectedResult = new String[] {"abcd", "abcd", "ba", "", "abdz", "dcba", "abd", "abd", "a", "a"};


    public static void main(String[] args) {
        int passedTest = 0;
        for(int i = 0; i < testStrings.length; i++) {
            String test = testStrings[i];
            String expected = expectedResult[i];
            System.out.println("Test " + i + ": " + "Testing: " + test + " Expected result: " + expected);
            String result = removeCharacter(test);
            boolean isPassed = result.equals(expected);
            System.out.println("Result: " + result + " " + isPassed + "\n");
            if(isPassed)
                passedTest++;
        }
        if(passedTest == testStrings.length)
            System.out.println("All test passed!");
    }

    private static String removeCharacter(String s) {
        if(s.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        int removeIndex = 0;
        while(removeIndex < s.length() - 1 && s.charAt(removeIndex) < s.charAt(removeIndex + 1)){
            removeIndex++;
        }
        sb.append(s, 0, removeIndex);
        sb.append(s.substring(removeIndex + 1));
        return sb.toString();
    }

}
