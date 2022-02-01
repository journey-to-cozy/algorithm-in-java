package src.sanga.algorithm.sort;

/**
 * 연결 리스트를 삽입 정렬로 정렬하라.
 * https://leetcode.com/problems/insertion-sort-list/
 */
class InsertionSortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        InsertionSortList insertionSortList = new InsertionSortList();
        insertionSortList.insertionSortList(head);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = head;
        ListNode previous = dummy;

        while (current!=null){
            ListNode next = current.next;

            while (previous.next != null && previous.next.val < current.val){
                previous = previous.next;
            }

            current.next = previous.next;
            previous.next = current;
            previous = dummy;
            current = next;
        }

        return dummy.next;
    }

    public ListNode insertionSortList2(ListNode head) {
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


}