/*
Given an array A consisting of N integers, return the maximum sum of two numbers whose digits add up to an equal sum.
if there are not two numbers whose digits have an equal sum, the function should return -1.
 */

import java.util.Arrays;
import java.util.HashMap;

public class NumbersWithEqualDigitSum {
    static int[][] testArrayOne = new int[][] {{51,71,17,42}, {42,33,60}, {51,32,43}, {51, 62, 17, 42, 33, 44, 71, 62}, {0, 0},{ 51, 72, 17, 41}, {33,33,11,11}};
    static int[] expectedResult = new int[] {93, 102, -1, 133, 0, -1, 66};

    public static void main(String[] args) {
        int passedTests = 0;
        for(int i = 0; i < testArrayOne.length; i++) {
            int result = maxEqualDigitSum(testArrayOne[i]);
            boolean isPassed = result == expectedResult[i];
            System.out.println("Test " + i + ": \n" + Arrays.toString(testArrayOne[i]));
            if(isPassed) {
                passedTests++;
            }
            System.out.println("Expected: " + expectedResult[i] + " result: " + result  + ", passed: " + isPassed + "\n");
        }
        if(passedTests == expectedResult.length)
            System.out.println("All tests passed!");
    }

    private static int maxEqualDigitSum(int[] arr) {
        int sum = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int curValue = arr[i];
            int key = getSum(curValue);
            if(map.containsKey(key)) {
                sum = Math.max(sum, map.get(key) + curValue);
            }
            map.put(key, Math.max(map.getOrDefault(key, 0), curValue));
        }

        return sum;
    }

    private static int getSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}
