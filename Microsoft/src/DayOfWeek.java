/*
Days of the week are represented as three-letter strings ("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").
Write a function solution that, given a string S representing the day of the week and an integer K (between 0 and 500), returns the day of the week that is K days later.
 */

import java.util.HashMap;

public class DayOfWeek {
    static String[] week = new String[]{"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    static String[] testStrings = new String[] {week[3], week[6], week[6], week[0], week[0], week[2]};
    static int[] testInt = new int[] {2, 23, 1, 6, 7, 0};
    static String[] expectedResult = new String[] {week[5], week[1], week[0], week[6], week[0], week[2]};

    public static void main(String[] args) {
        int passedTests = 0;
        for(int i = 0; i < testStrings.length; i++) {
            String result = getDay(testStrings[i], testInt[i]);
            boolean isPassed = result.equals(expectedResult[i]);
            System.out.println("Test " + i + ": " + testStrings[i] + " " + testInt[i] + " days");
            if(isPassed) {
                passedTests++;
            }
            System.out.println("Expected: " + expectedResult[i] + " result: " + result  + ", passed: " + isPassed + "\n");
        }
        if(passedTests == expectedResult.length)
            System.out.println("All tests passed!");
    }

    private static String getDay(String s, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < week.length; i++) {
            map.put(week[i], i);
        }
        return week[(map.get(s) + k) % 7];
    }

}
