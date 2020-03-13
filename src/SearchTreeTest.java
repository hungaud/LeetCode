public class SearchTreeTest {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(search(root, 23));
    }

    private static boolean search(Node node, int n) {
        if(node == null)
            return false;
        if(node.val == n)
            return true;

        return search(node.left, n) || search(node.right, n);
    }

    private static class Node {
        int val;
        Node left, right;

        public Node(int item)
        {
            val = item;
            left = right = null;
        }
    }
}
