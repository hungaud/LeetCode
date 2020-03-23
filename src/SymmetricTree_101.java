import java.util.Stack;

public class SymmetricTree_101 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(4);
        System.out.println(isSymmetric(tree));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        //return helper(root.left, root.right);
        return iterate(root.left, root.right);
    }

    private static boolean helper (TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        if(left == null || right == null || left.val != right.val)
            return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    private static boolean iterate(TreeNode left, TreeNode right) {
        if(left == null || right == null)
            return left == null && right == null;
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        TreeNode leftNode = left;
        TreeNode rightNode = right;

        while((leftNode != null || !leftStack.isEmpty()) && (rightNode != null || !rightStack.isEmpty())) {

            while(leftNode != null && rightNode != null) {
                leftStack.add(leftNode);
                rightStack.add(rightNode);
                leftNode = leftNode.left;
                rightNode = rightNode.right;
            }

            if(leftNode != null || rightNode != null) {
                return false;
            }
            leftNode = leftStack.pop();
            rightNode = rightStack.pop();
            if(leftNode.val != rightNode.val) {
                return false;
            }
            leftNode = leftNode.right;
            rightNode = rightNode.left;

        }

        return leftStack.isEmpty() && rightStack.isEmpty();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x;}
    }
}
