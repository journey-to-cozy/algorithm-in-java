package com.algorithm.sort;

import com.algorithm.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 * Given the head of a linked list, return the list after sorting it in ascending order.
 */
public class SortList {

	// merge sort
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// cut the list to two halves
		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		assert prev != null;
		prev.next = null;

		// sort each half
		ListNode node1 = sortList(head);
		ListNode node2 = sortList(slow);

		// merge node1 and node2
		return merge(node1, node2);
	}

	private ListNode getMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private ListNode merge(ListNode node1, ListNode node2) {
		ListNode listNode = new ListNode(0);
		ListNode p = listNode;

		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				p.next = node1;
				node1 = node1.next;
			} else {
				p.next = node2;
				node2 = node2.next;
			}

			p = p.next;
		}

		if (node1 != null) {
			p.next = node1;
		}

		if (node2 != null) {
			p.next = node2;
		}

		return listNode.next;
	}

	public static void main(String[] args) {
		ListNode tail = new ListNode(3);
		ListNode node1 = new ListNode(1, tail);
		ListNode node2 = new ListNode(2, node1);
		ListNode head = new ListNode(4, node2);
		
		SortList solution = new SortList();
		ListNode result = solution.sortList(head);

		System.out.println("result.val = " + result.val);
	}
}
