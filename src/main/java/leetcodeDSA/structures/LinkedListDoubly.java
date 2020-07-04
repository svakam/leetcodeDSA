package leetcodeDSA.structures;

public class LinkedListDoubly extends LinkedListSingly implements LinkedListMethods {
    NodeDouble head;
    NodeDouble tail;

    @Override
    public void addFirst(int value) {
        NodeDouble newNode = new NodeDouble(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head;
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
        if (head == null && index > 0) throw new IllegalArgumentException("Can't add at specified index: linked list is empty");
        if (head != null) {
            if (index == 0) {
                addFirst(value);
            } else {
                
            }
        }
    }

    @Override
    public Node removeFirst() {

    }

    @Override
    public Node removeLast() {

    }

    @Override
    public String printValues() {

    }

    @Override
    public Node peekHead() {

    }

    @Override
    public Node peekTail() {

    }

    @Override
    public Node peekAtIndex(int index) {

    }

    @Override
    public int size() {

    }

    @Override
    public boolean isEmpty() {

    }
}
