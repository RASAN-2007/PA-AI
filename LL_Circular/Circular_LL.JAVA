package Circular_LL;

public class Circular_LL {

    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    static class CircularLL {
        Node tail;
        Node head;

        CircularLL() {
            head = tail = null;
        }

        void push_front(int val) {
            Node newNode = new Node(val);
            if (head == null && tail == null) {
                head = tail = newNode;
                tail.next = head;
            } else {
                newNode.next = head;
                head = newNode;
                tail.next = head;
            }
        }

        void push_back(int val) {
            Node newNode = new Node(val);
            if (head == null && tail == null) {
                head = tail = newNode;
                tail.next = head;
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head;
            }
        }

        void pop_front() {
            if (head == null) {
                System.out.print("Linked List is empty");
                return;
            } else {
                if (head == tail) {
                    head = tail = null;
                } else {
                    head = head.next;
                    tail.next = head;
                }
            }
        }

        void pop_back() {
            if (head == null) {
                System.out.print("Linked List is empty");
                return;
            } else {
                Node temp = head;
                if (head == tail) {
                    head = tail = null;
                }
                while (temp.next != tail) {
                    temp = temp.next;
                }
                tail = temp;
                tail.next = head;
            }
        }

        void insert(int val, int pos) {
            if (pos <= 0) {
                System.out.print("Invallid position");
                return;
            }

            if (pos == 1) {
                push_front(val);
            } else {
                Node temp = head;
                for (int i = 1; i < pos - 1 && temp != null; ++i) {
                    if (temp == null) {
                        System.out.println("Invalid pos");
                        return;
                    }
                    temp = temp.next;
                }
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
                if (newNode.next == null) {
                    tail = newNode;
                }
                tail.next = head;
            }
        }

        void deleteNode(int k) {
            if (head == null || k <= 0)
                return;

            if (k == 1) {
                pop_front();
                return;
            }

            Node prev = head;
            for (int i = 1; i < k - 1 && prev != null; ++i)
                prev = prev.next;

            if (prev == null || prev.next == null)
                return;

            Node toDelete = prev.next;
            prev.next = toDelete.next;

            if (toDelete == tail) {
                tail = prev;
            }
            tail.next = head;
        }

        // this is normal display function to print all elements
        // void display() {
        //     if (head == null) return;
        //     Node temp = head;
        //     do {
        //         System.out.print(temp.data + " ");
        //         temp = temp.next;
        //     } while (temp != head);
        //     System.out.println();
        // }

        // this display method is used to check the circularity of the LL and prints elements more than once
        void display() {
            Node temp = head;
            int count = 0;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
                count++;
            } while (count < 10);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLL cLL = new CircularLL();
        cLL.push_front(1);
        cLL.push_front(2);
        cLL.push_back(3);
        cLL.push_back(6);
        cLL.push_back(5);
        cLL.pop_front();
        cLL.pop_back();
        cLL.insert(4, 3);
        cLL.deleteNode(3);
        cLL.display();
    }
}











// public class Doubly_CircularLinkedList {

//     static class Node {
//         int data;
//         Node next;
//         Node prev;

//         Node(int val) {
//             data = val;
//             next = prev = null;
//         }
//     }

//     static class doublyLL {
//         Node head;
//         Node tail;

//         doublyLL() {
//             head = tail = null;
//         }

//         void push_front(int val) {
//             Node newNode = new Node(val);
//             if (head == null && tail == null) {
//                 head = tail = newNode;
//             } else {
//                 newNode.next = head;
//                 head.prev = newNode;
//                 head = newNode;
//                 tail.next = head;
//             }
//         }

//         void push_back(int val) {
//             Node newNode = new Node(val);
//             if (head == null && tail == null) {
//                 head = tail = newNode;
//             } else {
//                 newNode.prev = tail;
//                 tail.next = newNode;
//                 tail = newNode;
//                 tail.next = head;
//             }
//         }

//         void insert(int val, int pos) {
//             if (pos <= 0) {
//                 System.out.println("Invalid pos");
//             }

//             if (pos == 1) {
//                 push_front(val);
//                 return;
//             }

//             Node temp = head;
//             for (int i = 1; i < pos - 1; i++) {
//                 if (temp == null) {
//                     System.out.println("Invalid pos");
//                     return;
//                 }
//                 temp = temp.next;
//             }

//             Node newNode = new Node(val);
//             newNode.next = temp.next;
//             temp.next.prev = newNode;
//             temp.next = newNode;
//             newNode.prev = temp;
//             tail.next = head;
//         }

//         void pop_front() {
//             if (head == null) {
//                 System.out.print("Linked List is empty");
//             } else {
//                 head = head.next;
//                 if (head != null)
//                     head.prev = null;
//                 if (head == null) {
//                     tail = null;
//                 }
//                 if (tail != null) tail.next = head;
//             }
//         }

//         void pop_back() {
//             if (head == null) {
//                 System.out.print("Linked List is empty");
//             } else {
//                 Node temp = tail;
//                 tail = tail.prev;
//                 tail.next = null;
//             }
//             if (tail != null) tail.next = head;
//         }

//         void deleteKthNode(int k) {
//             if (head == null || k <= 0) return;

//             if (k == 1) {
//                 head = head.next;
//                 head.prev = null;
//                 return;
//             }

//             Node prev = head;
//             for (int i = 1; prev != null && i < k - 1; i++) {
//                 prev = prev.next;
//             }

//             if (prev == null || prev.next == null) return;

//             Node toDelete = prev.next;
//             prev.next = toDelete.next;
//             if (toDelete.next != null) {
//                 toDelete.next.prev = prev;
//             }
//             tail.next = head;
//         }

//         void display() {
//             Node temp = head;
//             int count = 0;
//             do {
//                 System.out.print(temp.data + " ");
//                 temp = temp.next;
//                 count++;
//             } while (count < 10);
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         doublyLL dll = new doublyLL();
//         dll.push_front(2);
//         dll.push_front(1);
//         dll.push_back(3);
//         dll.push_back(4);
//         dll.push_back(5);
//         dll.pop_front();
//         dll.pop_back();
//         dll.insert(6, 2);
//         dll.deleteKthNode(2);
//         dll.display();
//     }
// }
