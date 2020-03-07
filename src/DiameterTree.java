public class DiameterTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int n = diameterOfBinaryTree(root);

    }

    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return max;
    }

    private static int find(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = find(node.left);
        int r = find(node.right);
        max = Math.max(max, l + r);
        return Math.max(l, r ) + 1;
    }

}
