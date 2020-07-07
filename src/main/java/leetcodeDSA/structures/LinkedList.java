package leetcodeDSA.structures;

public abstract class LinkedList implements LinkedListMethods {
    abstract public void addFirst(int value);
    abstract public void addLast(int value);
    abstract public void addAtIndex(int value, int index);
    abstract public Node removeFirst();
    abstract public Node removeLast();
    abstract public String printValues() throws ClassNotFoundException;
    abstract public Node peekHead();
    abstract public Node peekTail();
    abstract public Node peekAtIndex(int index);
    abstract public int size();
    abstract public boolean isEmpty();
}
