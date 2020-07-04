package leetcodeDSA.structures;

public class NodeDouble extends Node {
    NodeDouble previous;

    NodeDouble(int value) {
        super(value);
    }

    NodeDouble(int value, NodeDouble next, NodeDouble previous) {
        super(value, next);
        this.previous = previous;
    }

    public NodeDouble getPrevious() {
        return previous;
    }
}
