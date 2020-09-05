class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp = target - nums[i];
            if(hmap.containsKey(comp)){
                return new  int[] {hmap.get(comp),i};
            }
            
            hmap.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
