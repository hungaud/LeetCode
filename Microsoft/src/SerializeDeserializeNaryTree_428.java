import java.util.*;

public class SerializeDeserializeNaryTree_428 {

    public static void main(String[] args) {
        Codec code = new Codec();
        String originalData = "1 3 3 2 5 0 6 0 2 0 4 0";
        Node root = code.deserializePreOrder("1 3 3 2 5 0 6 0 2 0 4 0");
        String serialize = code.serializePreOrder(root);
        System.out.println("Preorder recursion using Size to know how many times to loop for children");
        System.out.println(originalData + " Original Data");
        System.out.println(serialize + " Serialized Data");


        originalData = "1 end 3 2 4 end 5 6 end end end end end";
        root = code.deserializeBFS("1 end 3 2 4 end 5 6 end end end end end");
        serialize = code.serializeBFS(root);

        System.out.println("\nBFS level order with end of each children as \"end\" ");
        System.out.println(originalData + " Original Data");
        System.out.println(serialize + " Serialized Data");
    }

    static class Codec {

        Codec() {}

        // Encodes a tree to a single string.
        public String serializePreOrder(Node root) {
            if(root == null)
                return "";
            StringBuilder sb = new StringBuilder();
            preorderHelper(root, sb);
            return sb.toString().trim();
        }

        private void preorderHelper(Node node, StringBuilder sb) {
            sb.append(node.val + " ");
            sb.append(node.children.size() + " ");
            for(int i = 0; i < node.children.size(); i++) {
                preorderHelper(node.children.get(i), sb);
            }
        }

        // Decodes your encoded data to tree.
        public Node deserializePreOrder(String data) {
            String[] dataArr = data.split(" ");
            if(data.length() == 0 || dataArr[0].equals("end"))
                return null;
            Queue<String> q = new LinkedList<>(Arrays.asList(dataArr));
            Node root = buildTreeHelperPreOrder(q);
            return root;
        }

        private Node buildTreeHelperPreOrder(Queue<String> q) {
            int cur = Integer.valueOf(q.poll());
            int size = Integer.valueOf(q.poll());
            Node node = new Node(Integer.valueOf(cur));
            node.children = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                node.children.add(buildTreeHelperPreOrder(q));
            }
            return node;
        }

        public String serializeBFS(Node root) {
            StringBuilder sb = new StringBuilder();
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()) {
                int len = q.size();
                for(int i = 0; i < len; i++) {
                    Node current = q.poll();
                    if(current == null) {
                        sb.append("end ");
                        continue;
                    }
                    sb.append(current.val + " ");
                    q.addAll(current.children);
                    q.add(null);
                }
            }
            return sb.toString().trim();
        }

        // Decodes your encoded data to tree.
        public Node deserializeBFS(String data) {
            String[] dataArr = data.split(" ");
            if(dataArr.length == 0 || dataArr[0].equals("end"))
                return null;

            int index = 2;
            Node root = new Node(Integer.valueOf(dataArr[0]));
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()) {
                int len = q.size();
                Node cur = q.poll();
                List<Node> children = new ArrayList<>();
                while(index < dataArr.length && !dataArr[index].equals("end")) {
                    Node child = new Node(Integer.valueOf(dataArr[index]));
                    children.add(child);
                    index++;
                }
                cur.children = children;
                q.addAll(children);
                index++;
            }
            return root;
        }

    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }
        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
