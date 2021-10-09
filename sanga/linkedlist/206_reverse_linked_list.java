package src.sanga.linkedlist;


/**
 * https://leetcode.com/problems/reverse-linked-list
 */
class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.reverseListRecursive(head);
    }


    // 반복
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next; // 기존 리스트노드의 next를 새로운 노드에 저장
            head.next = prev; // 뒤집기
            prev = head;
            head = next;
        }
        return prev; // 새로운 리스트노드의 head
    }

    // 재귀 구조
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) return null;

        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode node, ListNode prev) {
        if (node == null) {
            return prev;
        }

        final ListNode next = node.next;
        node.next = prev;
        return reverseList(next, node);
    }
}