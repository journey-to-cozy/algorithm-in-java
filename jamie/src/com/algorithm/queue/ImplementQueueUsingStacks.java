package com.algorithm.queue;

import java.util.Stack;

/**
 * 스택을 이용한 큐 구현
 * 스택을 이용해 다음 연산을 지원하는 큐를 구현하라.
 * push(x): 요소 x를 큐 마지막에 삽입한다.
 * pop(): 큐 처음에 있는 요소를 제거한다.
 * peek(): 큐 처음에 있는 요소를 조회한다.
 * empty(): 큐가 비어 있는지 여부를 리턴한다.
 */
public class ImplementQueueUsingStacks {

	class MyQueue {
		Stack<Integer> input;
		Stack<Integer> output;

		/** Initialize your data structure here. */
		public MyQueue() {
			input = new Stack<>();
			output = new Stack<>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			input.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			peek();
			return output.pop();
		}

		/** Get the front element. */
		public int peek() {
			if (output.empty()) {
				while (!input.empty())
					output.push(input.pop());
			}
			return output.peek();
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return input.empty() && output.empty();
		}
	}
}
