import itertools
import math

class Solution(object):
    def minAreaFreeRect(self, points):
        """
        :type points: List[List[int]]
        :rtype: float
        """
        points_set = set(map(tuple, points))
        min_area = float('inf')

        for p1, p2, p3 in itertools.combinations(points, 3):
            x1, y1 = p1
            x2, y2 = p2
            x3, y3 = p3

            # Check if p1, p2, and p3 are orthogonal
            if (x2 - x1) * (x3 - x1) + (y2 - y1) * (y3 - y1) == 0:
                # Calculate the fourth point of the potential rectangle
                x4, y4 = x2 + x3 - x1, y2 + y3 - y1

                if (x4, y4) in points_set:
                    # Calculate the area of the rectangle formed by p1, p2, p3, and p4
                    area = ((x2 - x1) ** 2 + (y2 - y1) ** 2) ** 0.5 * ((x3 - x1) ** 2 + (y3 - y1) ** 2) ** 0.5
                    min_area = min(min_area, area)

        return min_area if min_area != float('inf') else 0.0
