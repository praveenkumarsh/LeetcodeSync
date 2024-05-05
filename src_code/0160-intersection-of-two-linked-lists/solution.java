/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //utility function to check presence of intersection
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
        
        while(d1 != d2) {
            d1 = d1 == null? headB:d1.next;
            d2 = d2 == null? headA:d2.next;

            System.out.println("===== d1 : "+ (d1 == null ? null : d1.val) + " | d2 : " + (d2 == null ? null : d2.val));
        }
        
        return d1;
    }
}
