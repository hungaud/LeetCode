
import java.util.*;

public class SerializeAndDeserializeBinaryTree_297 {

    public static void main(String[] args) {
        TreeNode root = createTree();
        TreeNode root2 = deserializeBFS("[1, 2, 3, null, null, 4, 5, null, null, null, null]");
        System.out.println("Serialized bfs: " + serializeBFS(root2));

        String originalData = "1 2 null null 3 4 null null 5 null null";
        root2 = deserializePreorder(originalData);
        System.out.println(originalData + " OriginalData");
        System.out.println(serializePreorder(root2) + " Serlialized");

    }

    public static String serializePreorder(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        serializePreorder(root, sb);
        return sb.toString();
    }

    private static void serializePreorder(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("null ");
            return;
        }
        sb.append(node.val + " ");
        serializePreorder(node.left, sb);
        serializePreorder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserializePreorder(String data) {
        if(data.isEmpty())
            return null;
        String[] nodes = data.split(" ");
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(nodes));
        TreeNode root = deserializeHelper(q);
        return root;
    }

    private static TreeNode deserializeHelper(Queue<String> queue) {
        String cur = queue.poll();
        if(cur.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }


    public static String serializeBFS(TreeNode root) {
        //StringBuilder sb = new StringBuilder(root.val);
        ArrayList<Integer> list = new ArrayList<>();
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

    public static TreeNode deserializeBFS(String data) {
        if(data.isEmpty())
            return null;
        System.out.println(data);
        String[] nodes = data.substring(1, data.length() - 1).split(", ");
        System.out.println(data);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        TreeNode cur = root;
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.add(cur);
        int index = 1;
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
