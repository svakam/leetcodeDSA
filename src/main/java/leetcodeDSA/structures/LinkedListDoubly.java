package leetcodeDSA.structures;

public class LinkedListDoubly extends LinkedList {
    NodeDouble head;
    NodeDouble tail;
    NodeDouble current;

    public void addFirst(int value) {
        NodeDouble newNode = new NodeDouble(value);
        if (head == null) {
            tail = newNode;
        } else {
            newNode.next = head;
            newNode.next.previous = newNode;
        }
        head = newNode;
        this.size++;
    }

    public void addLast(int value) {
        NodeDouble newNode = new NodeDouble(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            NodeDouble temp = tail;
            tail = newNode;
            temp.next = newNode;
            newNode.previous = temp;
        }
        this.size++;
    }

    public void addAtIndex(int value, int index) {
        NodeDouble newNode = new NodeDouble(value);
        if (head == null) {
            addFirst(value);
            return;
        }
        if (index < ((size() - 1) / 2)) {
            if (head == null && index > 0) throw new IllegalArgumentException("Can't add at specified index: linked list is empty");
            if (head != null) {
                NodeDouble current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                NodeDouble temp = current.next;
                current.next = newNode;
                newNode.next = temp;
            }
        } else if (index > ((size() - 1) / 2)) {
            if (tail == null && index > 0) throw new IllegalArgumentException("Can't add at specified index: linked list is empty");
            if (tail != null) {
                NodeDouble current = tail;
                for (int i = size() - 1; i >= 0; i--) {
                    current = current.previous;
                }
                NodeDouble temp = current.previous;
                current.previous = newNode;
                newNode.previous = temp;
            }
        } else {
            if (head == null && index > 0) throw new IllegalArgumentException("Can't add at specified index: linked list is empty");
            if (head != null) {
                NodeDouble current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                NodeDouble temp = current.next;
                current.next = newNode;
                newNode.next = temp;
            }
        }
        this.size++;
    }

    public NodeDouble removeFirst() {
        NodeDouble temp = head;
        head = head.next;
        temp.next = null;
        head.previous = null;
        return temp;
    }

    public NodeDouble removeLast() {
        if (tail == null) throw new NullPointerException("Can't remove node: linked list is empty");
        NodeDouble temp = tail;
        tail = temp.previous;
        temp.next = null;
        this.size--;
        return temp;
    }

    public NodeDouble removeAtIndex(int index) {
        if (head == null) throw new NullPointerException("Can't remove node: linked list is empty");
        if (index == 0) {
            return removeFirst();
        }
        NodeDouble current;
        if (index < (size - 1) / 2 || index == (size - 1) / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size; i >= index; i--) {
                current = current.previous;
            }
        }
        current.previous.next = current.next;
        current.next = null;
        this.size--;
        return current;
    }

    public String printValues() {
        if (head == null) throw new NullPointerException("Can't print values: linked list is empty");
        StringBuilder s = new StringBuilder();
        NodeDouble current = head;
        while (current != null) {
            s.append(current.value).append(" ");
            current = current.next;
        }
        return s.toString();
    }

    public NodeDouble peekHead() {
        if (head == null) throw new NullPointerException("Can't peek: linked list is empty");
        return head;
    }

    public NodeDouble peekTail() {
        if (tail == null) throw new NullPointerException("Can't peek: linked list is empty");
        return tail;
    }

    public NodeDouble peekAtIndex(int index) {
        if (head == null || tail == null) throw new NullPointerException("Can't peek: linked list is empty");
        NodeDouble current;
        if (index < (size() - 1) / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else if (index > (size() - 1) / 2) {
            current = tail;
            for (int i = size() - 1; i > index; i--) {
                current = current.previous;
            }
        } else {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        return current;
    }

    public int size() {
        return this.size;
    }

    public int recalibrateSize() {
        current = head;
        int counter = 0;
        while (current != null) {
            current = current.next;
            counter++;
        }
        size = counter;
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
