package leetcodeDSA.structures;

public interface LinkedListMethods {
    void addFirst(Node newNode);
    void addLast(Node newNode);
    void addAtIndex(Node newNode, int index);
    Node removeFirst();
    Node removeLast();
    void printValues();
    Node peekHead();
    Node peekTail();
    Node peekAtIndex(int index);
    int size();
    boolean isEmpty();
}
