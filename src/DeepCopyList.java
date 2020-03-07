public class DeepCopyList {
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
        if(head == null) return null;
        Node original, current, result;
        original = head;
        while(original != null) {
            current = new Node(original.val);
            current.next = original.next;
            original.next = current;
            original = original.next.next;
        }
        original = head;
        current = original.next;
        boolean done = false;
        while(original != null && !done) {
            current.random = original.random != null ? original.random.next : null;
            original = original.next.next;
            if(current.next == null) {
                done = true;
            } else {
                current = current.next.next;
            }
        }
        result = head.next;
        current = result;
        while(current.next != null) {
            current.next = current.next.next;
            current = current.next;
        }
        return result;
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
