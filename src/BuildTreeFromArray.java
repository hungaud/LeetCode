public class BuildTreeFromArray {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        int[] arr = new int[] {-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBST(arr);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        //visted = new boolean[nums.length];
        TreeNode node = helper(nums, 0, nums.length - 1 );
        return node;

    }

    private static TreeNode helper(int[] nums, int low, int high) {
        if(low > high) return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}
