package src.sanga.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
class StackUsingQueue {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.top(); // 5
        stack.pop(); // 5
        stack.empty();

    }

}

/* one queue */
class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        // return queue.poll();
        return queue.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        // return queue.peek();
        return queue.element();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/* two queues */
class MyStack2{

}