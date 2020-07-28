import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructBSTfromPreorder_1008 {

    static int[][] testPreorder = new int[][] {{8,5,1,7,10,12}};
    static int[][] expectedResult = new int[][] {{1,5,7,8,10,12}};


    public static void main(String[] args) {
        int passedTest = 0;
        for(int i = 0; i < testPreorder.length; i++) {
            int[] testPre = testPreorder[i];
            int[] expected = expectedResult[i];
            System.out.println("Test " + i + ": " + "Testing: " + Arrays.toString(testPre) + " Expected result: " + Arrays.toString(expected));
            n = 0;
            TreeNode result = bstFromPreorder(testPre);
            List<Integer> list = new ArrayList<>();
            inTest(result, list);
            int[] res = new int[list.size()];
            for(int j = 0; j < list.size(); j++) {
                res[j] = list.get(j);
            }
            boolean isPassed =  Arrays.equals(res, expected);
            System.out.println("Result: " + result + " " + isPassed + "\n");
            if(isPassed)
                passedTest++;
        }
        if(passedTest == expectedResult.length)
            System.out.println("All test passed!");
    }

    static int n = 0;
    public static TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }

    public static TreeNode helper(int[] preorder, int max) {
        TreeNode root = new TreeNode(preorder[n]);
        n++;
        if(n < preorder.length && root.val > preorder[n]) {
            root.left = helper(preorder, root.val);
        }
        if(n < preorder.length && root.val < preorder[n] && preorder[n] < max) {
            root.right = helper(preorder, max);
        }
        return root;
    }

    public static void inTest(TreeNode head, List<Integer> res) {
        if(head == null)
            return;
        inTest(head.left, res);
        res.add(head.val);
        inTest(head.right, res);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

