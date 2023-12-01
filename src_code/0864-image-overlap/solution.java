class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        for (int i = -n + 1; i < n; i++) {
            for (int j = -n + 1; j < n; j++) {
                maxOverlap = Math.max(maxOverlap, countOverlap(img1, img2, i, j));
            }
        }

        return maxOverlap;
    }

    private int countOverlap(int[][] img1, int[][] img2, int offsetX, int offsetY) {
        int overlapCount = 0;
        int n = img1.length;

        for (int i = Math.max(0, -offsetX); i < Math.min(n, n - offsetX); i++) {
            for (int j = Math.max(0, -offsetY); j < Math.min(n, n - offsetY); j++) {
                overlapCount += img1[i][j] & img2[i + offsetX][j + offsetY];
            }
        }

        return overlapCount;
    }
}
