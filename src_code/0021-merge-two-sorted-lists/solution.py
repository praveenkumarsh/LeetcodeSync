# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeTwoLists(self, list1, list2):
        """
        Merge two sorted linked lists.
        
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        # Create a dummy node as the starting point of the merged list
        dummy = ListNode(-1)
        current = dummy  # Pointer to the current node in the merged list

        while list1 and list2:
            # Compare the values of the two lists' nodes
            if list1.val < list2.val:
                current.next = list1
                list1 = list1.next
            else:
                current.next = list2
                list2 = list2.next
            current = current.next

        # If one of the lists is not empty, append the remaining part to the merged list
        if list1:
            current.next = list1
        if list2:
            current.next = list2

        return dummy.next  # The merged list starts from the next node of the dummy
        
