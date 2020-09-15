class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int major = -1;
        for(int val:nums){
            if(count==0){
                major = val;
                count = 1;
            }else{
                if(val == major){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return major;
        
    }
}
