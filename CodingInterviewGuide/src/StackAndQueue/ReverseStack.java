package StackAndQueue;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈：
 * 入栈：1 2 3 4 5
 * 逆序后的栈为：5 4 3 2 1
 */
public class ReverseStack {

    public int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int num = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(num);
    }
}
