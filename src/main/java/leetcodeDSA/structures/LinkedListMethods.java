package leetcodeDSA.structures;

import leetcodeDSA.structures.Node;

interface LinkedListMethods {
    void addFirst(int value);
    void addLast(int value);
    void addAtIndex(int value, int index);
    Node removeFirst();
    Node removeLast();
    Node removeAtIndex(int index);
    String printValues() throws ClassNotFoundException;
    Node peekHead();
    Node peekTail();
    Node peekAtIndex(int index);
    int size();
    boolean isEmpty();
    int recalibrateSize(); // needed just in case a new method implementation that has to alter size of LL object, which in turn reassigns size
    // variable of LL object, erroneously updates size prior to or during testing
}
