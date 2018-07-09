package stacks;

import java.util.ArrayList;
import java.util.Stack;


public class SetOfStacks<E> {
    int maxStackSize;
    int currentStack;
    ArrayList<Stack<E>> stacks;
    ArrayList<Integer> stackSizes;

    public SetOfStacks(int maxStackSize) {
        this.maxStackSize = maxStackSize;
        stacks.add(new Stack<E>());
        stackSizes.add(0);
        currentStack = 0;
    }

    public boolean empty() {
        return stackSizes.get(currentStack) == 0;
    }

    public E peek() {
        return stacks.get(currentStack).peek();
    }

    public E pop() {
        int currentSize = stackSizes.get(currentStack);
        while(currentSize == 0) {
            currentStack--;
            if (currentStack < 0) {
                currentStack = 0;
                return null;
            }
            currentSize = stackSizes.get(currentStack);
        }

        E item = stacks.get(currentStack).pop();
        stackSizes.set(currentStack, currentSize - 1);
        return item;
    }

    public E push(E item) {
        int currentSize = stackSizes.get(currentStack);
        if (currentSize >= maxStackSize) {
            currentStack++;
            if( currentStack >= stacks.size()) {
                stacks.add(new Stack<E>());
                stackSizes.add(0);
            }
        }
        currentSize = stackSizes.get(currentSize) +1;
        stacks.get(currentStack).push(item);
        stackSizes.set(currentStack, currentSize);
        return item;
    }

    public E popAt(int index) {
        if (index < 0 || index >= stacks.size()) {
            return null;
        }
        if (stackSizes.get(index) == 0) {
            return null;
        }
        stackSizes.set(index, stackSizes.get(index));
        return stacks.get(index).pop();
    }

}
