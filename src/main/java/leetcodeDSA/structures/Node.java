package leetcodeDSA.structures;

public class Node {
    // default access modifier makes variables accessible across classes within the same package
    // private makes variables accessible within same class
    // public makes variables accessible globally
    // protected makes variables accessible within class and subclasses
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }
    public Node getNext() {
        return next;
    }
}
