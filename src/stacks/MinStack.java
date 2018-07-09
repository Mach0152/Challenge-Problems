package stacks;


public class MinStack {
    class StackNode{
        int value;
        StackNode next;
        int min;

        StackNode(int value) {
            this.value=value;
        }
    }

    private StackNode head;

    public MinStack() {
        head = null;
    }

    public MinStack(int value) {
        head = new StackNode(value);
        head.min=value;
        head.next=null;
    }

    public void push(int value) {
        StackNode node = new StackNode(value);
        if (head == null || value < head.value) {
            node.min = value;
        } else {
            node.min = head.min;
        }
        node.next = head;
        head = node;
    }

    public int pop() {
        if (head == null) {
            throw new Exception();
        }
        int value = head.value;
        head = head.next;
        return value;
    }

    public int min() {
        if (head == null) {
            return Integer.MAX_VALUE;
        }
        return head.min;
    }
}
