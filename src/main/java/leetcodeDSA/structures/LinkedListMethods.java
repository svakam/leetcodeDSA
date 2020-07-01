package leetcodeDSA.structures;

public interface LinkedListMethods {
    void addFirst(int value);
    void addLast(int value);
    void addAtIndex(int value, int index);
    Node removeFirst();
    Node removeLast();
    String printValues();
    void peekHead();
    void peekTail();
    Node peekAtIndex(int index);
    int size();
    boolean isEmpty();
}
