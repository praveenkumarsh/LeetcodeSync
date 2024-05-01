class Solution {
    // public int uniquePaths(int m, int n) {
    //     if(m == 1 || n == 1)
    //         return 1;
    //     m--;
    //     n--;
    //     if(m < n) {              // Swap, so that m is the bigger number
    //         m = m + n;
    //         n = m - n;
    //         m = m - n;
    //     }
    //     long res = 1;
    //     int j = 1;
    //     for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
    //         res *= i;
    //         res /= j;
    //     }
            
    //     return (int)res;
    // }

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[j] += dp[j - 1];
                for(int dpi : dp)
                    System.out.print(dpi + " ");
                System.out.println();
            }
        }

        for(int dpi : dp)
            System.out.print(dpi + " ");
        return dp[n - 1];
    }
}
