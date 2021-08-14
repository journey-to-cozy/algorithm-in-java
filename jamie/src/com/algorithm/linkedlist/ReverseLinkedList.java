package com.algorithm.linkedlist;

/*
* 연결 리스트를 뒤집어라.
* */
public class ReverseLinkedList {

	// 반복 구조
	public ListNode reverseList(ListNode head) {
		if (head == null) return null;

		ListNode node = head;
		ListNode prev = null;
		ListNode reversed = null;

		while (node != null) {
			final ListNode next = node.next;

			if (node.next == null) {
				reversed = node;
			}

			node.next = prev;
			prev = node;
			node = next;
		}

		return reversed;
	}

	// 재귀 구조
	public ListNode reverseListRecursive(ListNode head) {
		if (head == null) return null;

		return reverseList(head, null);
	}

	private ListNode reverseList(ListNode node, ListNode prev) {
		if (node == null) {
			return prev;
		}

		final ListNode next = node.next;
		node.next = prev;
		return reverseList(next, node);
	}
}
