import java.util.HashMap;

public class DeepCopyList_138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node head = createNode();
        Node copy = copyRandomList(head);
    }

    private static Node copyRandomList(Node head) {
        if(head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;
        while(current != null) {
            Node newNode = new Node(current.val);
            map.put(current, newNode);
            current = current.next;
        }
        current = head;
        while(current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }

    private static Node createNode() {
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        head.next = two;
        head.random = null;

        two.next = three;
        two.random = head;

        three.next = null;
        three.random = two;
        return head;
    }

}
