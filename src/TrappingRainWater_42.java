public class TrappingRainWater_42 {

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        int len = height.length;
        if(len == 0)
            return 0;
        int[] leftmax = new int[len];
        int[] rightmax = new int[len];
        int rainAmount = 0;
        leftmax[0] = height[0];
        rightmax[len - 1] = height[len - 1];
        for(int i = 1; i < len; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }
        for(int i = len - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }

        for(int i = 1; i < len - 1; i++) {
            if(height[i] < leftmax[i - 1] && height[i] < rightmax[i + 1]) {
                rainAmount += Math.min(leftmax[i - 1], rightmax[i + 1]) - height[i];
            }
        }
        return rainAmount;
    }

}
