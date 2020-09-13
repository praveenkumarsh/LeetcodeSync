class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Node node = null;
        // int[] result = new int[nums.length];
        List<Integer> result = Arrays.asList(new Integer[nums.length]);

        for (int i = nums.length-1; i >= 0; i--) {
            node = insertBST(node, nums[i], 0, result, i);
        }

        // List<Integer> ans = new ArrayList<>();
        // for (int res : result) {
        //     ans.add(res);
        // }
        return result;

        // return ans;
    }

    private Node insertBST(Node root, int val, int sum, List<Integer> result, int i) {
        if (root == null) {
            result.set( i, sum );
            // result[i] = sum;
            return new Node(val);
        }

        if (root.val < val) {
            sum += root.leftCount + 1;
            root.right = insertBST(root.right, val, sum, result, i);
        } else {
            root.left = insertBST(root.left, val, sum, result, i);
            root.leftCount += 1;
        }

        return root;
    }
}

class Node {
    Node left;
    Node right;
    int leftCount;
    int val;

    public Node(int val) {
        this.val = val;
    }
}
