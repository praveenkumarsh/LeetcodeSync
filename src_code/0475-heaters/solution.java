class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int n = heaters.length;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int h = 0;

        int res = 0;
        for (int house : houses) {
          while (h < n - 1 && heaters[h] + heaters[h + 1] <= house * 2) {
            h++;
          }
          
          res = Math.max(res, Math.abs(heaters[h] - house));
        }

        return res;
    }
}
