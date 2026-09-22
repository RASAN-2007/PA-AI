public class linkedlist_basic {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        void addFirst(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        void addLast(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                return;
            }

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        void delete(int data) {
            if (head == null) return;

            if (head.data == data) {
                head = head.next;
                return;
            }

            Node temp = head;

            while (temp.next != null && temp.next.data != data) {
                temp = temp.next;
            }

            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }

        void display() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);
        list.display();

        list.delete(20);
        list.display();
    }
}