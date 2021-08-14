package com.algorithm.linkedlist;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
		if (node1 == null)
			return node2;
		if (node2 == null)
			return node1;

		if (node1.val < node2.val) {
			node1.next = mergeTwoLists(node1.next, node2);
			return node1;
		} else {
			node2.next = mergeTwoLists(node1, node2.next);
			return node2;
		}
	}
}
