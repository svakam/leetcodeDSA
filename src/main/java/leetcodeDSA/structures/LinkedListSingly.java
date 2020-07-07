package leetcodeDSA.structures;

public class LinkedListSingly extends LinkedList {
    Node head;

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        this.size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    public void addAtIndex(int value, int index) {
        Node newNode = new Node(value);
        if (index < 0) throw new IllegalArgumentException("Can't add at specified index: index is negative");
        if (head == null && index > 0) throw new IllegalArgumentException("Can't add at specified index: linked list is empty");
        if (head != null) {
            if (index == 0) {
                addFirst(value);
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                    if (current == null) throw new IllegalArgumentException("Can't add at specified index: linked list is longer than index provided");
                }
                newNode.next = current.next;
                current.next = newNode;
            }
            // also test for index out of bounds
        }
        this.size++;
    }

    public Node removeFirst() {
        if (head == null) throw new NullPointerException("Can't remove node: linked list is empty");
        if (head.next == null) {
            Node temp = head;
            head = null;
            return temp;
        }
        Node temp = head;
        head = temp.next;
        temp.next = null;
        this.size--;
        return temp;
    }

    public Node removeLast() {
        if (head == null) throw new NullPointerException("Can't remove node: linked list is empty");
        if (head.next == null) {
            Node temp = head;
            head = null;
            return temp;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node temp = current;
        current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = null;
        this.size--;
        return temp;
    }

    public Node removeAtIndex(int index) {
        if (head == null) throw new IllegalArgumentException("Can't remove node: linked list is empty");
        if (index < 0) throw new IllegalArgumentException("Can't remove node: index is negative");
        Node temp = head;
        if (index == 0) {
            removeFirst();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            temp = current.next;
            if (temp.next == null) {
                current.next = null;
                return temp;
            }
            current.next = temp.next;
        }
        this.size--;
        return temp;
    }

    public String printValues() {
        if (head == null) throw new NullPointerException("Can't print values: linked list is empty");
        StringBuilder s = new StringBuilder();
        Node current = head;
        int counter = 0;
        while (current != null) {
            s.append("Node ").append(counter).append(": ").append(current.value).append("\n");
            current = current.next;
            counter++;
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
        return this.size;
    }

    public int recalibrateSize() {
        Node current = head;
        int counter = 0;
        while (current != null) {
            current = current.next;
            counter++;
        }
        this.size = counter;
        return this.size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
