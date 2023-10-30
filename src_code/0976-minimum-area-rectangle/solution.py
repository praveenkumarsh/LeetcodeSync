class Solution(object):
    def minAreaRect(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        point_set = set(map(tuple, points))
        min_area = float('inf')

        for i in range(len(points)):
            x1, y1 = points[i]
            for j in range(i + 1, len(points)):
                x2, y2 = points[j]

                # Only consider points with different x-coordinates and different y-coordinates
                if x1 != x2 and y1 != y2:
                    if (x1, y2) in point_set and (x2, y1) in point_set:
                        min_area = min(min_area, abs(x1 - x2) * abs(y1 - y2))

        return min_area if min_area != float('inf') else 0
        
