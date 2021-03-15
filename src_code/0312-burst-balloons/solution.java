class Solution {
    public int maxCoins33(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) 
            if (x > 0) 
                nums[n++] = x;
        nums[0] = nums[n++] = 1;
        
        int[][] dp = new int[n][n];
        
        for (int k = 2; k < n; ++k){
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i){
                    dp[left][right] = Math.max(dp[left][right], 
                                               nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        
        return dp[0][n - 1];
    }
    
    public int maxCoins(int[] inums) {
		int[] nums = new int[inums.length + 2];
		nums[0] = 1;
		nums[inums.length + 1] = 1;
		for (int i = 1; i < nums.length - 1; i++) {
			nums[i] = inums[i - 1];
		}

		int n = nums.length;

		int[][] dp = new int[n][n];

		for (int gap = 2; gap < n; gap++) {
			for (int l = 0; l < n - gap; l++) {
				int r = l + gap;

				for (int i = l + 1; i < r; i++) {
					dp[l][r] = Math.max(dp[l][r], nums[l] * nums[i] * nums[r] + dp[l][i] + dp[i][r]);
				}
			}
		}
		return dp[0][n - 1];
	}
}
