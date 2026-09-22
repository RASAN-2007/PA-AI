package LL_Singly;

public class Singly_LL {

    static class Node {
        int data;
        Node next;
        Node(int val) { data = val; next = null; }
    }

    static class LinkedList {
        private Node head;
        private Node tail;

        LinkedList() { head = null; tail = null; }
        // Java's garbage collector reclaims nodes automatically —
        // no destructor/free loop needed (unlike the original C++ ~LinkedList()).

        void push_front(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        void push_back(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        void pop_front() {
            if (head == null) {
                System.out.println("LL is empty");
                return;
            }
            if (head == tail) { // only one node
                head = tail = null;
                return;
            } else {
                head = head.next;
            }
        }

        void pop_back() {
            if (head == null) {
                System.out.println("LL is empty");
                return;
            }
            if (head == tail) {
                head = tail = null;
                return;
            }
            Node temp = head;
            while (temp.next != tail)
                temp = temp.next;
            tail = temp;
            tail.next = null;
        }

        void insertNode(int val, int pos) {
            if (pos <= 0) {
                System.out.println("Invalid pos");
                return;
            }
            if (pos == 1) {
                push_front(val);
                return;
            }
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                if (temp == null) { // position out of range
                    System.out.println("Invalid pos");
                    return;
                }
                temp = temp.next;
            }
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            if (newNode.next == null) { // inserted at end -> update tail
                tail = newNode;
            }
        }

        void deleteNode(int k) {
            if (head == null || k <= 0)
                return;

            if (k == 1) {
                if (head == tail) { // single node
                    head = tail = null;
                } else {
                    head = head.next;
                }
                return;
            }

            Node prev = head;
            for (int i = 1; i < k - 1 && prev != null; ++i)
                prev = prev.next;

            if (prev == null || prev.next == null)
                return; // kth node doesn't exist

            Node toDelete = prev.next;
            prev.next = toDelete.next;

            if (toDelete == tail) { // deleted last node -> update tail
                tail = prev;
            }
        }

        int searchNode(int key) {
            Node temp = head;
            int idx = 1;
            while (temp != null) {
                if (temp.data == key)
                    return idx;
                temp = temp.next;
                idx++;
            }
            return -1;
        }

        void printAll() {
            Node temp = head;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.data).append(" ");
                temp = temp.next;
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.push_front(1);
        ll.push_front(2);
        ll.push_front(3);
        ll.push_back(4);

        System.out.print("Before ops: ");
        ll.printAll(); // 3 2 1 4

        ll.pop_front();
        System.out.print("After pop_front: ");
        ll.printAll(); // 2 1 4

        ll.pop_back();
        System.out.print("After pop_back: ");
        ll.printAll(); // 2 1

        ll.insertNode(10, 2);
        System.out.print("After insertNode(10,1): ");
        ll.printAll(); // 2 10 1

        ll.deleteNode(1);
        System.out.print("After deleteNode(1): ");
        ll.printAll(); // 10 1

        ll.deleteNode(2);
        System.out.print("After deleteNode(2): ");
        ll.printAll(); // 10

        ll.deleteNode(1);
        System.out.print("After deleteNode(1): ");
        ll.printAll(); // (empty line)
    }
}
