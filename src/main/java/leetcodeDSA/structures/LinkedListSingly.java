package leetcodeDSA.structures;

import java.util.LinkedList;

public class LinkedListSingly implements LinkedListMethods {
    Node head = null;

    public void addFirst(int value) {
        Node current;
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            current = head;
            head = newNode;
            newNode.next = current;
        }
    }

    public void addLast(int value) {
        Node current;
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addAtIndex(int value, int index) {
        Node current;
        Node newNode = new Node(value);
        if (head == null && index > 0) throw new IllegalArgumentException("Can't add at specified index: linked list is empty");
        if (head != null) {
            if (index == 0) {
                addFirst(value);
            } else {
                current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    public Node removeFirst() {
        if (head == null) {
            System.out.println("Can't remove node: linked list is empty"); // sout or exception or?
        } else {
            Node current;
            current = head;
            head = current.next;
            current.next = null;
            return current;
        }
        return null;
    }

    public Node removeLast() {
        if (head == null) throw new IllegalArgumentException("Can't remove node: linked list is empty"); // sout or exception or?
        Node temp;
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        temp = current;
        temp = temp.next;
        System.out.println(temp.value);
        current.next = null;
        System.out.println(current.value);
        return temp;
    }

    public String printValues() {
        StringBuilder s = new StringBuilder();
        if (head == null) {
            return "Linked list is empty";
        } else {
            Node current = head;
            int counter = 0;
            while (current != null) {
                s.append("Node ").append(counter).append(": ").append(current.value).append("\n");
                current = current.next;
                counter++;
            }
        }
        return s.toString();
    }

    public Node peekHead() {
        if (head == null) throw new NullPointerException("Can't peek: linked list is empty");
        return head;
    }

    public Node peekTail() {
        if (head == null) throw new NullPointerException("Can't peek: linked list is empty");
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public Node peekAtIndex(int index) {
        if (head == null) throw new NullPointerException("Can't peek: linked list is empty");
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        Node current = head;
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
