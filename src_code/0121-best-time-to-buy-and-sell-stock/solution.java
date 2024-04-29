class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxPro = Integer.MIN_VALUE;
        for(int price : prices) {
            min = Math.min(price, min);
            maxPro = Math.max(maxPro, price - min);
        }
        return maxPro;
    }
}
