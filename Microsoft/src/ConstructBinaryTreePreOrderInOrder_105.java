public class ConstructBinaryTreePreOrderInOrder_105 {
    static int preIndex = 0;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public static void main(String[] args) {
        int[] pre = new int[] {3, 9, 8, 2, 20, 15, 7};
        int[] in = new int[] {8, 9, 2, 3, 15, 20, 7};

        TreeNode node = buildTree(pre, in);
        printInorder(node);
        //System.out.println(printInorder(node));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //TreeNode root = buildTree(0, preorder.length - 1, preorder, inorder);
        TreeNode root = buildTree2(0, 0, preorder.length - 1, preorder, inorder);

        return root;
    }

    private static TreeNode buildTree(int start, int end, int[] preorder, int[] inorder) {
        if(start > end)
            return null;
        TreeNode node = new TreeNode(preorder[preIndex]);
        preIndex++;
        if(start == end)
            return node;

        int inIndex = findIndex(inorder, node.val, start, end);
        node.left = buildTree(start, inIndex - 1, preorder, inorder);
        node.right = buildTree(inIndex + 1, end, preorder, inorder);


        return node;
    }

    public static TreeNode buildTree2(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = findIndex(inorder, root.val, inStart, inEnd);

        root.left = buildTree2(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = buildTree2(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    private static int findIndex(int[] arr, int num, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(arr[i] == num)
                return i;
        }
        return -1;
    }

    private static void printInorder(TreeNode node) {
        if(node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder((node.right));
    }

}
