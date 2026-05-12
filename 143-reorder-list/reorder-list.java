class Solution {
    public void reorderList(ListNode head) {

        // Edge case:
        // If list is empty, nothing to reorder
        if (head == null) return;

        // ---------------------------------------------------
        // STEP 1: Find the middle of the linked list
        // ---------------------------------------------------
        //
        // slow moves 1 step at a time
        // fast moves 2 steps at a time
        //
        // When fast reaches the end,
        // slow will be at the middle.
        //
        // Example:
        // 1 -> 2 -> 3 -> 4 -> 5
        //               ^
        //             slow
        //
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // ---------------------------------------------------
        // STEP 2: Reverse the second half
        // ---------------------------------------------------
        //
        // Current list:
        // 1 -> 2 -> 3 -> 4 -> 5
        //                ^
        //              slow
        //
        // second = 4 -> 5
        //
        // Break the list into two halves:
        // 1 -> 2 -> 3 -> null
        // 4 -> 5
        //
        ListNode second = slow.next;
        slow.next = null;

        // Standard iterative linked list reversal
        //
        // node will become the new head
        // of reversed second half
        //
        ListNode node = null;

        while (second != null) {

            // Store next node
            ListNode temp = second.next;

            // Reverse pointer
            second.next = node;

            // Move node forward
            node = second;

            // Move second forward
            second = temp;
        }

        // After reversal:
        // 5 -> 4 -> null

        // ---------------------------------------------------
        // STEP 3: Merge both halves alternately
        // ---------------------------------------------------
        //
        // First half : 1 -> 2 -> 3
        // Second half: 5 -> 4
        //
        // Result:
        // 1 -> 5 -> 2 -> 4 -> 3
        //
        ListNode first = head;

        // node is head of reversed second half
        second = node;

        while (second != null) {

            // Store next pointers before changing links
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // Attach node from second half
            first.next = second;

            // Attach next node from first half
            second.next = temp1;

            // Move both pointers forward
            first = temp1;
            second = temp2;
        }
    }
}