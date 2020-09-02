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
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>() {  
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val-o2.val;
        }
        };
        Queue<ListNode> pq = new PriorityQueue<>(cmp);
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        
        for(ListNode l:lists){
            if(l!=null){
                pq.add(l);
            }
        }
        
        while(!pq.isEmpty()){
            ListNode l = pq.poll();
            temp.next = l;
            temp = temp.next;
            if(l.next!=null){
                pq.add(l.next);
            }
            
        }
        return head.next;
        
    }
}
