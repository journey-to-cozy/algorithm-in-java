package com.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐를 이용한 스택 구현
 * 큐를 이용해 다음 연산을 지원하는 스택을 구현하라.
 * push(x): 요소 x를 스택에 삽입한다.
 * pop(): 스택의 첫 번째 요소를 삭제한다.
 * top(): 스택의 첫 번째 요소를 가져온다.
 * empty(): 스택이 비어 있는지 여부를 리턴한다.
 */
public class ImplementStackUsingQueues {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.empty());
	}
}

class MyStack {
	Queue<Integer> queue = new LinkedList<>();

	/** Initialize your data structure here. */
	public MyStack() {

	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue.add(x);

		int size = queue.size();
		// while (size-- > 1) {
		// 	queue.add(queue.poll());
		// }
		while (size > 1) {
			queue.add(queue.poll());
			size--;
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		/**
		 * remove(): 예외 발생
		 * poll(): return null
		 */
		return queue.poll();
	}

	/** Get the top element. */
	public int top() {
		/**
		 * element(): 예외 발생
		 * peek(): null 반환
		 */
		return queue.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}
}