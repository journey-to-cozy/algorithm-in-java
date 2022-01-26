package com.algorithm.sort;

import com.algorithm.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 * Given the head of a singly linked list, sort the list using insertion sort,
 * and return the sorted list's head.
 */
public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode preInsert = new ListNode(0);
		ListNode toInsert = new ListNode(0);
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		while (head != null && head.next != null) {
			if (head.val <= head.next.val) {
				head = head.next;
			} else {
				toInsert = head.next;

				// Locate preInsert
				preInsert = dummyHead;

				while (preInsert.next.val < toInsert.val) {
					preInsert = preInsert.next;
				}
				head.next = toInsert.next;

				// Insert toInsert after preInsert
				toInsert.next = preInsert.next;
				preInsert.next = toInsert;
			}
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {

	}
}
