package LL_Doubly;

public class doubly_LL   {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int val) {
            data = val;
            next = prev = null;
        }
    }

    static class doublyLL {
        Node head;
        Node tail;

        doublyLL() {
            head = tail = null;
        }

        void push_front(int val) {
            Node newNode = new Node(val);
            if (head == null && tail == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        void push_back(int val) {
            Node newNode = new Node(val);
            if (head == null && tail == null) {
                head = tail = newNode;
            } else {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }
        }

        void insert(int val, int pos) {
            if (pos <= 0) {
                System.out.println("Invalid pos");
            }

            if (pos == 1) {
                push_front(val);
                return;
            }

            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                if (temp == null) {
                    System.out.println("Invalid pos");
                    return;
                }
                temp = temp.next;
            }

            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
        }

        void pop_front() {
            if (head == null) {
                System.out.print("Linked List is empty");
            } else {
                head = head.next;
                if (head != null)
                    head.prev = null;
                if (head == null) {
                    tail = null;
                }
            }
        }

        void pop_back() {
            if (head == null) {
                System.out.print("Linked List is empty");
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }

        void deleteKthNode(int k) {
            if (head == null || k <= 0) return; // invalid case

            // Case 1: Delete head (k == 1)
            if (k == 1) {
                head = head.next;
                head.prev = null;
                return;
            }

            // Traverse to (k-1)th node
            Node prev = head;
            for (int i = 1; prev != null && i < k - 1; i++) {
                prev = prev.next;
            }

            // If kth node doesn't exist
            if (prev == null || prev.next == null) return;

            // Delete kth node
            Node toDelete = prev.next;
            prev.next = toDelete.next;
            toDelete.next.prev = prev;
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
        doublyLL dll = new doublyLL();
        dll.push_front(2);
        dll.push_front(1);
        dll.push_back(3);
        dll.push_back(4);
        dll.push_back(5);
        dll.pop_front();
        dll.pop_back();
        dll.insert(6, 2);
        dll.deleteKthNode(2);
        dll.printAll();
    }
}
