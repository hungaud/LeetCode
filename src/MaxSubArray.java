public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = new int[] {-3,-2,-1};
        int n = maxSubArray(arr);
    }

        public static int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0)
                sum = A[i];
            else
                sum += A[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }

}
