class Solution {
    public boolean isPalindrome(ListNode head) {

        // Empty list or single node is always palindrome
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        // -----------------------------------
        // Find middle of linked list
        // -----------------------------------
        //
        // slow moves 1 step
        // fast moves 2 steps
        //
        // When fast reaches end,
        // slow will be at middle.

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // -----------------------------------
        // Reverse second half
        // -----------------------------------

        ListNode prev = null;

        while (slow != null) {

            ListNode temp = slow.next;

            slow.next = prev;

            prev = slow;

            slow = temp;
        }

        // -----------------------------------
        // Compare first half and reversed half
        // -----------------------------------

        ListNode start_L = head;
        ListNode start_R = prev;

        while (start_R != null) {

            if (start_L.val != start_R.val) {
                return false;
            }

            start_L = start_L.next;
            start_R = start_R.next;
        }

        return true;
    }
}