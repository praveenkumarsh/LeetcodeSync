class Solution {
    public int[][] merge(int[][] intervals) {
         if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Sort intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);

            if (currentInterval[0] <= lastMergedInterval[1]) {
                // Merge overlapping intervals
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            } else {
                // Add non-overlapping interval to the result
                mergedIntervals.add(currentInterval);
            }
        }

        return mergedIntervals.toArray(new int[0][]);
    }
}
