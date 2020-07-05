package leetcodeDSA.structures;

public class LinkedListDoubly extends LinkedListSingly implements LinkedListMethods {
    NodeDouble head;
    NodeDouble tail;

    @Override
    public int size() {
        if (head == tail) return 1;
        NodeDouble currentFront = head;
        NodeDouble currentBack = tail;
        int i = 0;
        while (true) {
            if (currentFront.next == currentBack && i > 0) {
                return i * 2;
            } else if (currentFront.next == currentBack && i == 0) {
                return 2;
            }
            if (currentFront == currentBack && i > 0) {
                return (i * 2) - 1;
            }
            currentFront = currentFront.next;
            currentBack = currentBack.previous;
            i++;
        }
    }

    @Override
    public void addFirst(int value) {
        NodeDouble newNode = new NodeDouble(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            NodeDouble temp = head;
            head = newNode;
            newNode.next = temp;
        }
    }

    @Override
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
    }

    @Override
    public void addAtIndex(int value, int index) {
        NodeDouble newNode = new NodeDouble(value);
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
    }

    @Override
    public NodeDouble removeLast() {
        if (tail == null) throw new NullPointerException("Can't remove node: linked list is empty");
        NodeDouble temp = tail;
        tail = temp.previous;
        temp.next = null;
        return temp;
    }

    @Override
    public NodeDouble peekTail() {
        if (tail == null) throw new NullPointerException("Can't peek: linked list is empty");
        return tail;
    }

    @Override
    public NodeDouble peekAtIndex(int index) {
        if (head == null || tail == null) throw new NullPointerException("Can't peek: linked list is empty");
        NodeDouble current;
        if (index < (size() - 1) / 2) {
            current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
        } else if (index > (size() - 1) / 2) {
            current = tail;
            for (int i = size() - 1; i >= 0; i--) {
                current = current.previous;
            }
        } else {
            current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
        }
        return current;
    }
}
