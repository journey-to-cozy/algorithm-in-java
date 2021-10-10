package com.algorithm.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.algorithm.linkedlist.ListNode;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

		// Queue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

		if (lists == null) return null;

		ListNode head = new ListNode(0);
		ListNode tail = head;

		for (ListNode node : lists) {
			if (node != null)
				heap.offer(node);
		}

		while (!heap.isEmpty()) {
			tail.next = heap.poll();
			tail = tail.next;
			if (tail.next != null)
				heap.offer(tail.next);
		}
		return head.next;
	}
}
