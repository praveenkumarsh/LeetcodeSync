class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
          for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= i) {
              dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
          }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    
    //Valid Reason for below code not working is that we may have to use other coin before using of greatest currency
    // public int coinChange(int[] coins, int amount) {
    //     Arrays.sort(coins);
    //     int count = 0;
    //     int j = coins.length-1;
    //     while(j>=0&&amount>=0){
    //         int c = (amount/coins[j]);
    //         amount-=c*coins[j];
    //         count+=c;
    //         j--;
    //     }
    //     if(amount!=0){
    //         return -1;
    //     }
    //     return count; 
    // }
}
