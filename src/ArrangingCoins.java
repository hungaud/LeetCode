import java.util.Arrays;
import java.util.HashMap;

public class ArrangingCoins {

    static int[][] testArrayOne = new int[][] {{5, 8, 100, 44, 33, 83, 3, 1, 5}};
    static int[][] expectedResult = new int[][] {{2, 3, 13, 8, 7, 12, 2, 1, 2}};

    public static void main(String[] args) {
        int passedTests = 0;
        for(int i = 0; i < testArrayOne.length; i++) {
            int[] result = arrange(testArrayOne[i]);
            boolean isPassed = Arrays.equals(expectedResult[i], result);
            System.out.println("Test " + i + ": " + Arrays.toString(testArrayOne[i]));
            if(isPassed) {
                passedTests++;
            }
            System.out.println("Expected: " + Arrays.toString(expectedResult[i]) + " result: " + Arrays.toString(result)  + ", passed: " + isPassed + "\n");
        }
        if(passedTests == expectedResult.length)
            System.out.println("All tests passed!");
    }

    private static int[] arrange (int[] coins) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int n : coins) {
            max = Math.max(n, max);
        }
        int count = 0;
        int prevLevelCount = 0;
        int currentLevelCount = 1;
        for(int i = 1; i <= max; i++) {
            if(currentLevelCount - prevLevelCount == 1) {
                count++;
                prevLevelCount = currentLevelCount;
                currentLevelCount = 1;
            } else {
                currentLevelCount++;
            }
            map.put(i, count);

        }
        int[] res = new int[coins.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = map.get(coins[i]);
        }
        return res;
    }

}
