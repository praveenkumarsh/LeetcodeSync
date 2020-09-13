class Solution {
    public int findDuplicate(int[] nums) {
        //we are checking like detecting loops in linkedlist
        
        int tortoise = nums[0];
        int hare = nums[0];
        do{
            //travel single step
            tortoise = nums[tortoise];
            //travel double steps
            hare = nums[hare];
            hare = nums[hare];
        } while(tortoise !=hare);
        
        tortoise = nums[0];
        while (tortoise!=hare){
            //travel single step
            tortoise = nums[tortoise];
            //travel single step
            hare = nums[hare];
        }
        
        return tortoise;
    }
}
