package src.sanga.linkedlist;

/**
 * 역순으로 연결 리스트의 숫자를 더하라.
 * https://leetcode.com/problems/add-two-numbers/
 */

class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode iterator = head;
        int carry = 0;

        while (l1 != null | l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            // new digits
            int sum = val1 + val2 + carry;
            int currentDigit = sum % 10;
            carry = sum / 10;
            iterator.next = new ListNode(currentDigit);

            // update
            iterator = iterator.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) iterator.next = new ListNode(carry);

        return head.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return addTwoNumber(l1, l2, 0);
    }

    public ListNode addTwoNumber(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        ListNode result = new ListNode();
        int value = carry;
        if (l1 != null) {
            value += l1.val;
        }
        if (l2 != null) {
            value += l2.val;
        }
        result.val = value % 10;

        if (l1 != null || l2 != null) {
            ListNode next = addTwoNumber(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
            result.next = next;
        }

        return result;
    }

}