class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    
    
//     public int lengthOfLIS(int[] nums) {
//         if(nums.length==0){
//             return 0;
//         }
//         int[] dp = new int[nums.length];
//         dp[0] = 1;
//         int maxlen = 1;
        
//         for(int i=1;i<dp.length;i++){
//             int maxval = 0;
//             for(int j=0;j<i;j++){
//                 if(nums[i]>nums[j]){
//                     maxval = Math.max(maxval,dp[j]);
//                 }
//             }
            
//             dp[i] = maxval+1;
//             maxlen = Math.max(maxlen,dp[i]);
//         }
        
//         return maxlen;
//     }
}
