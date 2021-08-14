package src.sanga;

/**
 * 역순으로 연결 리스트의 숫자를 더하라.
 * https://leetcode.com/problems/add-two-numbers/
 */

class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode iterator = head;
        int carry = 0;

        while(l1 != null | l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            int currentDigit = sum % 10;

            carry = sum / 10;

            iterator.next = new ListNode(currentDigit);
            iterator = iterator.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) iterator.next = new ListNode(carry);

        return head.next;
    }
}