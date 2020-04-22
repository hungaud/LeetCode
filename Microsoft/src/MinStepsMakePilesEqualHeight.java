/*
Alexa is given n piles of equal or unequal heights. In one step,
Alexa can remove any number of boxes from the pile which has the maximum height and try to make it equal to the one which is just lower than the maximum height of the stack.
Determine the minimum number of steps required to make all of the piles equal in height.
 */

import java.util.Arrays;

public class MinStepsMakePilesEqualHeight {

    static int[][] testArrayOne = new int[][] {{5,2,1}, {4,5,5,4,2}};
    static int[] expectedResult = new int[] {3, 6};

    public static void main(String[] args) {
        int passedTests = 0;
        for(int i = 0; i < testArrayOne.length; i++) {
            int result = getMinSteps(testArrayOne[i]);
            boolean isPassed = result == expectedResult[i];
            System.out.println("Test " + i + ": " + Arrays.toString(testArrayOne[i]));
            if(isPassed) {
                passedTests++;
            }
            System.out.println("Expected: " + expectedResult[i] + " result: " + result  + ", passed: " + isPassed + "\n");
        }
        if(passedTests == expectedResult.length)
            System.out.println("All tests passed!");
    }

    private static int getMinSteps(int[] piles) {
        Arrays.sort(piles);
        int count = 0;
        int[] dp = new int[piles.length];
        dp[0] = 0;
        for(int i = 1; i < piles.length; i++) {
            if(piles[i] == piles[i - 1])
                dp[i] = dp[i - 1];
            else
                dp[i] = dp[i - 1] + 1;
            count += dp[i];
        }
        return count;
    }

}
