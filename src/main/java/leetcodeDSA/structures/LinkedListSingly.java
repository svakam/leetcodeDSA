package leetcodeDSA.structures;

import java.util.LinkedList;

public class LinkedListSingly implements LinkedListMethods {
    Node head = null;
    Node current;

    public void addFirst(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            current = head;
            head = newNode;
            newNode.next = current;
            current = null;
        }
    }

    public void addLast(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            current = null;
        }
    }

    public void addAtIndex(Node newNode, int index) {
        if (head == null && index > 0) {
            throw new IllegalArgumentException("Can't add at specified index: linked list is empty"); // is exception type valid to use here?
        } else if (head != null) {
            if (index == 0) {
                addFirst(newNode);
            } else {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                // tbc
            }
        }
    }

    public Node removeFirst() {
        if (head == null) {
            System.out.println("Can't remove node: linked list is empty"); // sout or exception or?
        } else {
            current = head;
            head = current.next;
            current.next = null;
        }
        return current;
    }

    public Node removeLast() {
        if (head == null) throw new IllegalArgumentException("Can't remove node: linked list is empty"); // sout or exception or?
        Node temp;
        current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        temp = current;
        temp = temp.next;
        current.next = null;
        return temp;
    }

    public void printValues() {
        if (head == null) {
            System.out.println("Linked list is empty");
        } else {
            current = head;
            int counter = 0;
            while (current != null) {
                System.out.format("node %d: %d%n", counter + 1, current.value);
                current = current.next;
            }
            current = null;
        }
    }

    public Node peekHead() {
        if (head == null) throw new NullPointerException("Can't peek: linked list is empty");
        return head;
    }

    public Node peekTail() {
        if (head == null) throw new NullPointerException("Can't peek: linked list is empty");
        current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public Node peekAtIndex(int index) {
        if (head == null) throw new NullPointerException("Can't peek: linked list is empty");
        current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        current = head;
        int counter = 0;
        while (current != null) { // current.next query can falsely increment counter by an additional 1
            counter++;
            current = current.next;
        }
        return counter;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
