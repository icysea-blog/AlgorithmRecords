package StackAndQueue;

import java.util.Stack;

/**
 * 一个栈中元素的类型为整型,现在想将该栈从顶到底按从大到小的顺序排序,
 * 只许申请一个栈。除此之外,可以申请新的变量,但不能申请额外的数据结构。
 * 如何完成排序?
 */
public class SortStackByStack {

    /**
     * stack 顶到底从大到小，则help 顶到底从小到大
     * cur为stack弹出的元素
     * 若cur大于help栈顶元素，则help弹栈入stack，直到cur小于等于help的栈顶元素，将cur压入栈
     * 若cur小于等于栈顶元素，则直接压入help
     * @param stack
     */
    public void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
