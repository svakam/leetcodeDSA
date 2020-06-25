package leetcodeDSA.structures;

public class NodeLLDouble extends Node {
    NodeLLDouble pointerTwo;

    NodeLLDouble(int value, Node pointerOne, NodeLLDouble pointerTwo) {
        super(value, pointerOne);
        this.pointerTwo = pointerTwo;
    }
}
