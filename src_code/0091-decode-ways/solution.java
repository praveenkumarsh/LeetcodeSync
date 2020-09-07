class Solution {
    public int numDecodings(String s) {         //Let s = 226
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();                     // n = 3
        
        int[] dp = new int[n + 1];              //dp of length 4 [0,0,0,0]
        
        dp[0] = 1;                              //[1,0,0,0]
        
        dp[1] = s.charAt(0) != '0' ? 1 : 0;     //[1,1,0,0]
        
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));         //first  = 2    |   6
            int second = Integer.valueOf(s.substring(i - 2, i));        //second = 22   |   26
            if (first >= 1 && first <= 9) {
               dp[i] += dp[i-1];                                        //dp[1,1,1,0]   |   dp[1,1,2,2]
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];                                       //dp[1,1,2,0]   |   dp[1,1,2,3]
            }
        }
        return dp[n];                              //3
    }
}
