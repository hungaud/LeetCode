/*
    Write a function to store the right most value at each level in a binary tree

 */

import java.util.ArrayList;
import java.util.List;

public class MockInterview {

    public static void main(String[] args) {
        getRightMost(new TreeNode());
    }

    public static List<Integer> getRightMost(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 1, res);
        return res;
    }

    public static void dfs(TreeNode root, int level, List<Integer> res) {
        if(root == null) {
            return;
        }
        if(level > res.size()) {
            res.add(root.val);
        }
        dfs(root.right, level + 1, res);
        dfs(root.left, level + 1, res);
    }

     public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
    }
}




