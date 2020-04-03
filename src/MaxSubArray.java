public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int n = maxSubArray(arr);
        System.out.println(n);
    }

        public static int maxSubArray(int[] nums) {
            int[] arr = new int[nums.length];
            int max = nums[0];
            arr[0] = nums[0];

            for(int i = 1; i < nums.length; i++){
                int prevMax = arr[i - 1];
                int current = nums[i];
                if(current < current + prevMax) {
                    arr[i] = current + prevMax;
                } else {
                    arr[i] = nums[i];
                }
                max = Math.max(max, arr[i]);

            }
            return max;
    }

}
