package com.algorithm.linkedlist;

/**
 * 인덱스 m에서 n까지를 역순으로 만들어라. 인덱스 m은 1부터 시작한다.
 */
public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		// 예외처리
		if (head == null || head.next == null || left == right) return head;

		ListNode pre, dummy = new ListNode(0);
		pre = dummy;
		dummy.next = head;

		for (int i = 0; i < left - 1; i++) {
			pre = pre.next;
		}

		ListNode cur = pre.next;
		ListNode p = pre.next;
		ListNode node = null;

		for (int i = 0; i < right - left; i++) {
			ListNode nxt = cur.next;
			cur.next = node;
			node = cur;
			cur = nxt;
		}
		p.next = cur;
		pre.next = node;

		return dummy.next;
	}

	// 코코 코드 추가
	public ListNode reverseBetween2(ListNode head, int left, int right) {
		if (head == null || head.next == null || left == right) return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		// set pre
		ListNode pre = dummy;
		for (int i = 0; i < left - 1; i++)
			pre = pre.next;

		// reverse
		ListNode start = pre.next;
		ListNode then = start.next;

		for (int i = 0; i < right - left; i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}

		return dummy.next;
	}
}
