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
    ListNode secNode = null;
    ListNode ff = secNode;
    public ListNode reverseList(ListNode n) {
        rev(n);
        if(secNode!=null)
            secNode.next = null;
        return ff;
        
    }
    
    public void rev(ListNode n){
        if(n==null){
            return;
        }
        if(n.next == null){
		    secNode = n;
            ff = secNode;
		    return;

	    }
	    rev(n.next);
	    secNode.next = n;
        secNode = secNode.next;
        return;
    }
}
