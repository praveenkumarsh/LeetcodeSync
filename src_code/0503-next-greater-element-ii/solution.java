class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=(n*2)-1;i>=0;i--){
            
            while(!stack.empty() && nums[i%n]>=nums[stack.peek()]){
                stack.pop();
            }
            
            if(stack.empty()){
                result[i%n] = -1;
            }else{
                result[i%n] = nums[stack.peek()];
            } 
            
            stack.push(i%n);
            
        }
        
        return result;
        
    }
}
    
    
        
