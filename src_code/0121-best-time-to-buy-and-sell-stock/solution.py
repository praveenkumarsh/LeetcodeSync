class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0  # No profit can be obtained with an empty list
        
        min_price = prices[0]  # Initialize the minimum price to the first day's price
        max_profit = 0  # Initialize the maximum profit to zero
        
        for price in prices:
            if price < min_price:
                min_price = price  # Update the minimum price
            else:
                max_profit = max(max_profit, price - min_price)  # Update the maximum profit if selling at the current price is more profitable
        
        return max_profit
