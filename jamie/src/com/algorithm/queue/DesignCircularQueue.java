package com.algorithm.queue;

/*
 * 원형 큐를 디자인하라.
 */
public class DesignCircularQueue {
}

class MyCircularQueue {
	final int[] array;

	int front;
	int rear = -1;
	int len = 0;

	public MyCircularQueue(int k) {
		array = new int[k];
	}

	public boolean enQueue(int value) {
		if (isFull())
			return false;

		rear = (rear + 1) % array.length;
		array[rear] = value;
		len++;

		return true;
	}

	public boolean deQueue() {
		if (isEmpty())
			return false;

		front = (front + 1) % array.length;
		len--;

		return true;
	}

	public int Front() {
		return isEmpty() ? -1 : array[front];
	}

	public int Rear() {
		return isEmpty() ? -1 : array[rear];
	}

	public boolean isEmpty() {
		return len == 0;
	}

	public boolean isFull() {
		return len == array.length;
	}
}
