package stacks;

import java.util.Stack;


public class SortStack {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<Integer>();
        if (stack == null || stack.empty()) {
            return;
        }

        while (!stack.empty()) {
            Integer i = stack.pop();
            placeInStack(i, temp, stack);
        }
        while (! temp.empty()) {
            stack.push(temp.pop());
        }
    }

    private static void placeInStack(Integer i, Stack<Integer> temp, Stack<Integer> stack) {
        int count = 0;
        while(!temp.isEmpty() && i < temp.peek()) {
            stack.push(temp.pop());
            count++;
        }
        temp.push(i);
        for(int j = 0; j < count; j++) {
            temp.push(stack.pop());
        }
    }
}
