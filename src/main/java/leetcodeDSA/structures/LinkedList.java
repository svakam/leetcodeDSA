package leetcodeDSA.structures;

public abstract class LinkedList implements LinkedListMethods {
    int size;

    LinkedList() {
        this.size = 0;
    }

    abstract public void addFirst(int value);
    abstract public void addLast(int value);
    abstract public void addAtIndex(int value, int index);
    abstract public Node removeFirst();
    abstract public Node removeLast();
    abstract public Node removeAtIndex(int index);
    abstract public String printValues() throws ClassNotFoundException;
    abstract public Node peekHead();
    abstract public Node peekTail();
    abstract public Node peekAtIndex(int index);
    abstract public int size();
    abstract public boolean isEmpty();
}
