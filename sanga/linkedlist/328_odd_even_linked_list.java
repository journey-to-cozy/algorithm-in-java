package src.sanga.linkedlist;


/**
 * 연결 리스트를 홀수 노드 다음에 짝수 노드가 오도록 재구성하라.
 * https://leetcode.com/problems/odd-even-linked-list/
 */
class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}