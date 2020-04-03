import java.util.Arrays;

public class BestTimeToBuySellStocksIndices {

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 3, 1, 9, 0, 44};
        System.out.println(Arrays.toString(getBestBuySellIndex(nums)));
    }

    private static int[] getBestBuySellIndex(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0, l = 0;
        int[] res = new int[2];
        for(int i=1;i<nums.length;i++) {
            int gain = nums[i] - nums[i-1];
            maxEndingHere += gain;
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                res[0] = Math.max(l-1, 0);
                res[1] = i;
            }
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
                l = i+1;
            }
        }
        return res;
    }

}
