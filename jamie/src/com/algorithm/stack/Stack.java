package com.algorithm.stack;

public class Stack {
	Node last;

	class Node {
		Node item;
		Node next;

		public Node(Node item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	public Stack(Node last) {
		this.last = last;
	}

	void push(Node item) {
		this.last = new Node(item, this.last);
	}

	Node pop() {
		Node item = this.last.item;
		this.last = this.last.next;
		return item;
	}
}
