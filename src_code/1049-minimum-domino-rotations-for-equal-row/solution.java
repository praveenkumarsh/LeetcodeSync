class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minFlips = Integer.MAX_VALUE;

		//INSTEAD OF TOP[0] AND BOTTOM[0], WE USE ALL POSSIBLE VALUES OF DICE[1,2,3,4,5,6]
        for (int i = 1; i <= 6; i++) {
            minFlips = Math.min(minFlips, helper(tops, bottoms, i));
            minFlips = Math.min(minFlips, helper(bottoms, tops, i));
        }

        return minFlips == Integer.MAX_VALUE ? -1 : minFlips;
    }

    private int helper(int[] tops, int[] bottoms, int target) {
        int n = tops.length;
        int minFlips = 0;

        for (int i = 0; i < n; i++) {
            if (tops[i] != target && bottoms[i] != target) return Integer.MAX_VALUE;
            if (tops[i] != target) minFlips++;
        }
        return minFlips;
    }
    
}
