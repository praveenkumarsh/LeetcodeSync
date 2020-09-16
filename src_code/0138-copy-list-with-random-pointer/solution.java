/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
   public Node copyRandomList(Node head) {
      if(head == null){
          return head;
    }
    
    Node node = head;
    
    //head: 1 - 2 - 3 - 4
    
    //First loop, add copy after node directly
    while(node != null){
        Node next = node.next; //so in the example, in first loop, next now is 2
        node.next = new Node(node.val); //in first loop, node.next now is 1'
        node.next.next = next; //so in first loop, it is 1 - 1' - 2now
        node = next; //in first loop, for next node, 2
    }
    
    //After loop, it is currently, 1 - 1' - 2 - 2' - 3 - 3' - 4 - 4'
    
    //Second loop, link random for copyhead
    node = head;
    while(node != null){
        if(node.random != null){
            node.next.random = node.random.next; //in first loop, it will be 1' = 3'
        }
        node = node.next.next; //in first loop, it will be 2
    }
    
    //Third loop, divide into head and copyhead
    node = head;
    Node copyHead = node.next;  //it is 1' initially
    Node copy = copyHead; //it is 1' initially
    while(copy.next != null){
        //first copy.next is 2
        node.next = node.next.next; //In first loop, node.next now is 2
        node = node.next; //In first loop, node now is 2
        
        copy.next = copy.next.next; //In first loop, copy.next is 2'
        copy = copy.next; //In first loop, copy is 2'
        
    }
    //Last step
    node.next = node.next.next; 
    
    return copyHead;
 }
}
