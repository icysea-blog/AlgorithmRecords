package StackAndQueue;

import java.util.Stack;

/**
 * 题目：实现一个特殊的栈,在实现栈的基本功能的基础上,再实现返回栈中最小元素的操作。
 * 要求：
 *  （1）pop、push、 getMin操作的时间复杂度都是O(1)。
 *  （2）设计的栈类型可以使用现成的栈结构。
 * @author lirong
 */
public class StackWithGetMinFunction {

    Stack<Integer> stackData;
    Stack<Integer> stackMin;

    public StackWithGetMinFunction() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    /**
     * 方法1：
     * 入栈：
     *  stackData：直接入栈
     *  stackMin：若栈空，入栈；若栈非空，与栈顶元素比较，若比栈顶元素小，压入，否则，重复压入栈顶元素
     * 出栈：
     *  stackData：非空出栈
     *  stackMin：非空出栈
     * getMin：
     *  stackMin：非空返回返回栈顶
     */
    public void push1(int num) {
        stackData.push(num);
        if (stackMin.isEmpty()) {
            stackMin.push(num);
            return;
        }
        stackMin.push(Math.min(stackMin.peek(), num));
    }

    public int pop1() {
        if (stackData.isEmpty()) {
            return -1;
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin1() {
        if (stackMin.isEmpty()) {
            return -1;
        }
        return stackMin.peek();
    }

    /**
     * 方法2：与方法1的区别在于，方法2比较节省空间
     * 入栈：
     *  stackData：直接入栈
     *  stackMin：
     *      若栈空，入栈
     *      若栈非空，若小于等于栈顶元素，则入栈；否则，不执行任何操作
     * 出栈：
     *  stackData：非空，直接出栈记为value
     *  stackMin：value若等于栈顶元素，则出栈；否则，不执行任何操作
     * getMin：
     *  stackMin：非空返回栈顶
     */
    public void push2(int num) {
        stackData.push(num);
        if (stackMin.isEmpty()) {
            stackMin.push(num);
            return;
        }
        if (num <= stackMin.peek()) {
            stackMin.push(num);
        }
    }

    public int pop2() {
        if (stackData.isEmpty()) {
            return -1;
        }
        int value = stackData.pop();
        if (value == stackMin.peek()) {
            stackMin.pop();
        }
        return value;
    }

    public int getMin2() {
        if (stackMin.isEmpty()) {
            return -1;
        }
        return stackMin.peek();
    }
}
