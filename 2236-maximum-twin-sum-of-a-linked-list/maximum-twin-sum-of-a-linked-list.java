/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseLL(ListNode head){

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;

        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }

        ListNode first = head;
        ListNode second = reverseLL(slow);

        System.out.println(first.val);
        System.out.println(second.val);

        int maxi = Integer.MIN_VALUE;
        while(second != null ){
            int sum = first.val + second.val;
            maxi = Math.max(maxi, sum);

            first = first.next;
            second = second.next;
        }   

        return maxi;
    }
}