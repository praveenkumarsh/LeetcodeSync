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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                dummy.next = new ListNode(l1.val);
                l1 = l1.next;
                dummy = dummy.next;
            }else if(l2.val<l1.val){
                dummy.next = new ListNode(l2.val);
                l2 = l2.next;
                dummy = dummy.next;
            }else{
                dummy.next = new ListNode(l1.val);
                dummy = dummy.next;
                dummy.next = new ListNode(l2.val);
                l1 = l1.next;
                l2 = l2.next;
                dummy = dummy.next;
                
            }
        }
        
        while(l1!=null){
            dummy.next = new ListNode(l1.val);
            dummy = dummy.next;
            l1 = l1.next;
        }
        while(l2!=null){
            dummy.next = new ListNode(l2.val);
            dummy = dummy.next;
            l2 = l2.next;
        }
        return res.next;
        
    }
}
