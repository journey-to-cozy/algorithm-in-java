package src.sanga;


/**
 * 연결 리스트가 팰린드롬 구조인지 판별하라
 * https://leetcode.com/problems/palindrome-linked-list/
 */
class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reversed(slow);
        fast = head;

        while(slow != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reversed(ListNode head) {
        ListNode prev = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}