package com.algorithm.linkedlist;

/*
* Do it! 자료구조와 함께 배우는 알고리즘 입문 자바 편
* 연결 리스트
* */
public class LinkedList<E> {

	// node
	class Node<E> {
		private E data;
		private Node<E> next;

		// 생성자
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head;
	private Node<E> current;

	// 비어 있는 연결 리스트 생성
	public LinkedList() {
		head = current = null;
	}
}
