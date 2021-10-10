package com.algorithm.deque;

public class DesignCircularDeque {
	public static void main(String[] args) {
		MyCircularDeque circularDeque = new MyCircularDeque(5);
		circularDeque.insertFront(1);
		circularDeque.insertLast(4);
		circularDeque.insertFront(2);
		circularDeque.insertLast(3);
		System.out.println(circularDeque.getFront()); // 2
		System.out.println(circularDeque.getRear()); // 3
	}
}

class MyCircularDeque {
	int[] queue;
	int front, rear;
	int count;

	/** Initialize your data structure here. Set the size of the deque to be k. */
	public MyCircularDeque(int k) {
		queue = new int[k];
		front = -1;
		rear = k - 1;
		// rear = -1;
		count = 0;
	}

	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	public boolean insertFront(int value) {
		if (isFull()) {
			return false;
		}

		front = (front - 1 + queue.length) % queue.length;
		// if (isEmpty()) {
		// 	rear = front;
		// }
		queue[front] = value;
		count++;

		return true;
	}

	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	public boolean insertLast(int value) {
		if (isFull()) {
			return false;
		}

		rear = (rear + 1) % queue.length;
		// if (isEmpty()) {
		// 	front = rear;
		// }
		queue[rear] = value;
		count++;

		return true;
	}

	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	public boolean deleteFront() {
		if (isEmpty()) {
			return false;
		}
		front = (front + 1) % queue.length;
		count--;

		return true;
	}

	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	public boolean deleteLast() {
		if (isEmpty()) {
			return false;
		}
		rear = (rear - 1 + queue.length) % queue.length;
		count--;

		return true;
	}

	/** Get the front item from the deque. */
	public int getFront() {
		return isEmpty() ? -1 : queue[front];
	}

	/** Get the last item from the deque. */
	public int getRear() {
		return isEmpty() ? -1 : queue[rear];
	}

	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		return count == 0;
	}

	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		return count == queue.length;
	}
}
