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

	// iterative
	public ListNode swapPairsByCoco(ListNode head) {
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode current = temp;

		while (current.next != null && current.next.next != null) {
			ListNode first = current.next;
			ListNode second = current.next.next;

			first.next = second.next;
			current.next = second;
			current.next.next = first;

			current = current.next.next;
		}

		return temp.next;
	}
}
