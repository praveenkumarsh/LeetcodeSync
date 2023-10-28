# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def dfs(node):
            if node is None:
                serialized.append("None")
            else:
                serialized.append(str(node.val))
                dfs(node.left)
                dfs(node.right)               
        
        serialized = []
        dfs(root)
        return ','.join(serialized)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def build_tree():
            val = next(values)
            if(val == "None"):
                return None
            node = TreeNode(int(val))
            node.left = build_tree()
            node.right = build_tree()
            return node
 
        values = iter(data.split(','))
        return build_tree()
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
