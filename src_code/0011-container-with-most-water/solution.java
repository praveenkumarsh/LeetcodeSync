class Solution {
    public int maxArea(int[] height) {
        int mArea = 0;
        int l  =0;
        int r = height.length-1;
        while(l<r){
             mArea = Math.max(mArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return mArea;
        
    }
}
