class Solution {
    public int trap(int[] height) {
        
        if(height.length==0){
            return 0;
        }
        
        
        int n = height.length;
        int[] l_height = new int[n];
        int[] r_height = new int[n];
        int total_water = 0;
        
        l_height[0] = height[0];
        for(int i=1;i<n;i++){
            l_height[i] = Math.max(height[i],l_height[i-1]);
        }
        
        r_height[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            r_height[i] = Math.max(height[i],r_height[i+1]);
        }
        
        for(int i=1;i<n-1;i++){
            total_water += Math.min(l_height[i],r_height[i])-height[i];
        }
        
        return total_water;
        
    }
}
