package StackAndQueue;

import java.util.Stack;

/**
 * 编写一个类,用两个栈实现队列,支持队列的基本操作(ad、 poll, peek)
 * 思路：
 *  一个栈作为压入栈,在压入数据时只往这个栈中压入,记为 stackpush;
 *  另一个栈只作为弹出栈,在弹出数据时只从这个栈弹出,记为 stackpop
 * 遵循如下规则：
 *  1.如果 stackpush 要往 stackpop 中压入数据,那么必须一次性把 stackpush 中的数据全部压入
 *  2.如果 stackpop 不为空, stackpush 绝对不能向 stackpop中压入数据。
 * @author lirong
 */
public class ImplementQueueUsingStacks {

    Stack<Integer> stackPush;
    Stack<Integer> stackPop;

    public ImplementQueueUsingStacks() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void pushToPop() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int num) {
        stackPush.push(num);
        pushToPop();
    }

    public int poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            return -1;
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            return -1;
        }
        pushToPop();
        return stackPop.peek();
    }
}
