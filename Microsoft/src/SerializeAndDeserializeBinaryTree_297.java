
import java.util.*;

public class SerializeAndDeserializeBinaryTree_297 {

    public static void main(String[] args) {
        TreeNode root = createTree();
        TreeNode root2 = deserialize("[-1, -1, 0, 1, null, null, null, null]");
        System.out.println(serialize(root2));
    }
    public static String serialize(TreeNode root) {
        //StringBuilder sb = new StringBuilder(root.val);
        ArrayList<Integer> list = new ArrayList<>();
        //list.add(root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur != null) {
                    list.add(cur.val);
                    queue.add(cur.left);
                    queue.add(cur.right);
                } else {
                    list.add(null);
                }
            }
        }
        System.out.println(list.toString());
        return list.toString();
    }

    public static TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        System.out.println(data);
        String[] nodes = data.substring(1, data.length() - 1).split(", ");
        System.out.println(data);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));
        TreeNode cur = root;
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.add(cur);
        int index = 2;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                cur = queue.poll();
                if(!nodes[index].equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.add(cur.left);
                } else {
                    cur.left = null;
                }
                index++;

                if(!nodes[index].equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.add(cur.right);
                } else {
                    cur.right = null;
                }
                index++;

            }
        }
        return root;
    }

    private static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        return root;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
