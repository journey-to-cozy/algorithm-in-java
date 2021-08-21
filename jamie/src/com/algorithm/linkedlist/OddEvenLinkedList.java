package com.algorithm.linkedlist;

/**
 * 연결 리스트를 홀수 노드 다음에 짝수 노드가 오도록 재구성하라.
 * 공간 복잡도 O(1), 시간 복잡도 O(n)에 풀이하라.
 */
public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		// 예외처리
		if (head == null) return null;

		ListNode odd = head; // 홀수 변수
		ListNode even = head.next; // 짝수 변수
		ListNode evenHead = head.next; // 짝수의 head

		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			odd = odd.next;
			even.next = even.next.next;
			even = even.next;
		}
		// 홀수 노드의 마지막을 짝수 헤드로 연결
		odd.next = evenHead;

		return head;
	}
}
