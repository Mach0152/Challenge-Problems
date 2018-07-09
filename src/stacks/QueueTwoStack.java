package stacks;

import java.util.Stack;


public class QueueTwoStack<E> {
    private Stack<E> head;
    private Stack<E> tail;

    public QueueTwoStack(){
        head = new Stack<E>();
        tail = new Stack<E>();
    }

    public void add(E item) {
        if(head.size() == 0 && tail.size() != 0) {
            pushAll(tail,head);
        }
        head.push(item);
    }

    public E remove() {
        if (tail.size() == 0) {
            pushAll(head,tail);
        }
        if (tail.size() == 0) {
            return null;
        }
        return tail.pop();

    }

    private void pushAll(Stack from, Stack to) {
        while (!from.empty()) {
            to.push(from.pop());
        }

    }
}
