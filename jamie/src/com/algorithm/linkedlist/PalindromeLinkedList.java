package com.algorithm.linkedlist;

/**
 * 팰린드롬 연결 리스트
 * 연결 리스트가 팰린드롬 구조인지 판별하라.
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		PalindromeLinkedList solution = new PalindromeLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);

		System.out.println(solution.isPalindrome(head));
	}

	/*
	* two pointers(Runner)
	* */
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) { // 입력값이 홀수일 경우 한 칸 더 이동
			slow = slow.next;
		}

		ListNode tail = reverse(slow);

		while (tail != null) {
			if (head.val != tail.val) {
				return false;
			}

			head = head.next;
			tail = tail.next;
		}

		return true;
	}

	private ListNode reverse(ListNode node) {
		ListNode tail = null;

		while (node != null) {
			ListNode next = node.next;
			node.next = tail;
			tail = node;
			node = next;
		}

		return tail;
	}
}
