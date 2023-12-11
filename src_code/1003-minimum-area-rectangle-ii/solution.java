class Solution {
    public double minAreaFreeRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        for (int[] point : points) {
            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }

        double minArea = Double.MAX_VALUE;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx1 = points[j][0] - points[i][0];
                int dy1 = points[j][1] - points[i][1];

                for (int k = j + 1; k < n; k++) {
                    int dx2 = points[k][0] - points[i][0];
                    int dy2 = points[k][1] - points[i][1];

                    if (dx1 * dx2 + dy1 * dy2 != 0) continue;

                    int x = dx1 + points[k][0];
                    int y = dy1 + points[k][1];

                    if (map.get(x) != null && map.get(x).contains(y)) {
                        double area = Math.sqrt(dx1*dx1 + dy1*dy1) * Math.sqrt(dx2*dx2 + dy2*dy2);
                        if(area < minArea){
                            minArea = area;
                        }
                    }
                }
            }
        }

        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }
}
