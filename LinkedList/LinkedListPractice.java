public class LinkedListPractice {
    public static Node insertAfter(Node current, int trackId) {
        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
        return newNode;
    }

    public static Node removeTask(Node head, int taskId) {
        if (head == null) {
            return null;
        }
        if (head.val == taskId) {
            return head.next;
        }

        Node prev = head;
        Node curr = head.next;
        while (curr != null && curr.val != taskId) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
        }
        return head;
    }

    public static Node reverseHistory(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node findMiddleServer(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean hasRedirectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static Node mergeLogStreams(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        insertAfter(head, 99);
        printList(head);

        Node removed = removeTask(head, 2);
        printList(removed);

        Node reversed = reverseHistory(head);
        printList(reversed);

        System.out.println("Middle: " + findMiddleServer(reversed).val);
        System.out.println("Has loop: " + hasRedirectLoop(reversed));

        Node a = new Node(1);
        a.next = new Node(3);
        a.next.next = new Node(5);

        Node b = new Node(2);
        b.next = new Node(4);
        b.next.next = new Node(6);

        Node merged = mergeLogStreams(a, b);
        printList(merged);
    }
}
