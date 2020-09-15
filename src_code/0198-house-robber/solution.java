/*
https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        
        int prev1 = 0;
        int prev2 = 0;
        
        for (int num : nums) {
            //sample run
            /*
            [2,7,9,3,1]
            step1->
            
            current :   |2|7|9 |3 |1 |
                        | | |  |  |  |
            tmp     :   |0|2|7 |11|11|
            prev1   :   |2|7|11|11|12|
            prev2   :   |0|2|7 |11|11|
            */
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
            
        }
        return prev1;
    }
}
