package com.algorithm.queue;

/*
 * 원형 큐를 디자인하라.
 */
public class DesignCircularQueue {

	class MyCircularQueue {
		final int[] array;
		// int front, rear = -1, len = 0;

		int front;
		int rear = -1;
		int len = 0;

		public MyCircularQueue(int k) {
			array = new int[k];
		}

		public boolean enQueue(int value) {
			if (!isFull()) {
				rear = (rear + 1) % array.length;
				array[rear] = value;
				len++;

				return true;
			} else
				return false;
		}

		public boolean deQueue() {
			if (!isEmpty()) {
				front = (front + 1) % array.length;
				len--;

				return true;
			} else
				return false;
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
}
