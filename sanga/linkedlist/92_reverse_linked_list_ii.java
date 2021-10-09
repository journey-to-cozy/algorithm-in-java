package src.sanga.linkedlist;


/**
 * 인덱스 m에서 n까지를 역순으로 만들어라
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Set pre
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) pre = pre.next;

        // Reverse
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