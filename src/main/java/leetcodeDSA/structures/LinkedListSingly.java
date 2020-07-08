package leetcodeDSA.structures;

public class LinkedListSingly extends LinkedList {
    Node head;
    Node current;

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
            current = head;
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
        if (this.head == null) throw new NullPointerException("Can't remove node: linked list is empty");
        this.current = head;
        head = this.current.next;
        this.current.next = null;
        this.size--;
        return this.current;
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
        this.current = this.head;
        int counter = 0;
        while (this.current != null) {
            this.current = this.current.next;
            counter++;
        }
        this.size = counter;
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}
