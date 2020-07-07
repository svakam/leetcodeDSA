package leetcodeDSA.structures;

public class NodeDouble extends Node {
    NodeDouble next;
    NodeDouble previous;

    NodeDouble(int value) {
        super(value);
    }

    NodeDouble(int value, NodeDouble next, NodeDouble previous) {
        super(value);
        this.next = next;
        this.previous = previous;
    }
}
