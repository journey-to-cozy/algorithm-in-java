package src.sanga.data_structure.linkedlist;


/**
 * 연결리스트를 입력받아, 인접한 두개의 노드를 스왑하라
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */

class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) return head;
        ListNode first = head;
        ListNode second = first.next;
        first.next = second.next;
        second.next = first;
        first.next = swapPairs(first.next);
        return second;
    }

    public ListNode swapPairs2(ListNode head) {
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