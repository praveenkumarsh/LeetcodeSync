class Solution(object):

    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        n = len(height)
        if n == 0:
            return 0

        left_max = [0] * n
        right_max = [0] * n

        # Calculate the maximum height on the left for each position
        left_max[0] = height[0]
        for i in range(1, n):
            left_max[i] = max(left_max[i - 1], height[i])

        # Calculate the maximum height on the right for each position
        right_max[n - 1] = height[n - 1]
        for i in range(n - 2, -1, -1):
            right_max[i] = max(right_max[i + 1], height[i])

        trapped_water = 0

        # Calculate trapped water for each position
        for i in range(n):
            trapped_water += min(left_max[i], right_max[i]) - height[i]

        return trapped_water
        
