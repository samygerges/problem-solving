package leetcode;

import java.util.ArrayDeque;

public class MyCircularDeque {
    private ArrayDeque<Integer> queue;
    private int k;

    public MyCircularDeque(int k) {
        queue = new ArrayDeque<>();
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (queue.size() < k) {
            queue.push(value);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (queue.size() < k) {
            queue.add(value);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (queue.isEmpty()) {
            return false;
        }
        queue.poll();
        return true;
    }

    public boolean deleteLast() {
        if (queue.isEmpty()) {
            return false;
        }
        queue.removeLast();
        return true;
    }

    public int getFront() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }

    public int getRear() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.getLast();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.size() == k;
    }
}
