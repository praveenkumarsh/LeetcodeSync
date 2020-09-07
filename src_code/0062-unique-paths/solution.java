class Solution {
    // public int uniquePaths(int m, int n) {
    //     int[][] grid = new int[m][n];
    //     for(int i = 0; i<m; i++){
    //         for(int j = 0; j<n; j++){
    //             if(i==0||j==0)
    //                 grid[i][j] = 1;
    //             else
    //                 grid[i][j] = grid[i][j-1] + grid[i-1][j];
    //         }
    //     }
    //     return grid[m-1][n-1];
    // }
    
    
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
            
        return (int)res;
    }
}
