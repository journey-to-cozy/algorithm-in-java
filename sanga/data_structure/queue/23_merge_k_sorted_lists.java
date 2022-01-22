package src.sanga.data_structure.queue;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists
 */
class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(3);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(7);

        ListNode listNode3 = new ListNode(1);
        listNode3.next = new ListNode(8);

        ListNode[] lists = {listNode1, listNode2, listNode3};

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        mergeKSortedLists.mergeKLists(lists);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node == null) continue;
            queue.add(node);
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while(!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) queue.add(curr.next);
        }

        return dummyHead.next;
    }
}
