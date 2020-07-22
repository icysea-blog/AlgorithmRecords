package StackAndQueue;

import java.util.LinkedList;

/**
 * 有一个整型数组ar和一个大小为w的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置,记录每个窗口的最大值。
 * 如果数组长度为n,窗口大小为w,则一共产生n-w+1个窗口的最大值。
 */
public class GetMaxWindow {

    /**
     * 双端队列实现，队列中存放arr中的下标
     */
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() == i - w) {
                queue.pollFirst();
            }
            if (i >= w - 1) {
                result[index++] = arr[queue.peekFirst()];
            }
        }
        return result;
    }
}
