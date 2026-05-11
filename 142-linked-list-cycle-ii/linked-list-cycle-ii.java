/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                
                ListNode tempHead = head;
                while (true) {
                    
                    if (tempHead == slow) {
                        return tempHead;
                    }  
                    tempHead = tempHead.next;
                    slow = slow.next;

                    
                }
            }
        }

        return null;
    }
}