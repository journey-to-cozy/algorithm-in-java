package src.sanga.queue;

/**
 * https://leetcode.com/problems/design-circular-queue/
 */

class DesignCircularQueue{
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(4);
        myCircularQueue.Rear();
        myCircularQueue.isFull();
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(4);
        myCircularQueue.Front();
        myCircularQueue.Rear();
    }
}


class MyCircularQueue {
    final int[] cQueue;
    int front;
    int rear = -1;
    int len = 0;
    int size;

    public MyCircularQueue(int k) {
        cQueue = new int[k];
        size = k;
    }

    public boolean enQueue(int val) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % size;
        cQueue[rear] = val;
        len++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % size;
        len--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : cQueue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : cQueue[rear];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == cQueue.length;
    }
}