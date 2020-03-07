public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,3,12};
        moveZeroes(arr);
    }

    private static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

}
