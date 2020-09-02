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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode dummy2 = dummy;
        while (head!=null && head.next!=null){
            ListNode current =  head;
            ListNode temp = head.next;
            ListNode link = head.next.next;

            current.next = link;
            dummy.next = temp;
            temp.next = current;

            head = head.next;
            dummy = dummy.next.next;
        }
        return dummy2.next;
    }
}
