package leetcodeDSA.structures;

public class NodeLLDouble extends Node {
    NodeLLDouble nextTwo;

    NodeLLDouble(int value, Node next, NodeLLDouble nextTwo) {
        super(value, next);
        this.nextTwo = nextTwo;
    }
}
