package com.algorithm.linkedlist;

public class SwapNodesInPairs {

	// timeout
	public ListNode swapPairs(ListNode head) {
		if (head == null) return null;

		ListNode current = head;

		while (current != null && current.next != null) {
			current.val = current.next.val;
			current.next.val = current.val;
		}

		return head;
	}

	// recursive
	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode n1 = head;
		ListNode n2 = head.next;

		n1.next = n2.next;
		n2.next = n1;

		n1.next = swapPairs2(n1.next);

		return n2;
	}
}
