class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // if (asteroids == null) {
        //     return null;
        // } else if (asteroids.length <= 1) {
        //     return asteroids;
        // }
        Stack<Integer> stack = new Stack();
        for(int ast: asteroids){
            while(!stack.isEmpty()&&ast<0&&stack.peek()>0&&stack.peek()<-ast){
                stack.pop();
            }
            if(!stack.isEmpty()&&ast<0&&stack.peek()>0){
                while(stack.peek()<-ast){
                    stack.pop();
                }
                if(stack.peek()==-ast){
                    stack.pop();
                }
                continue;
            }
            stack.push(ast);
        }
        
        int[] ans = new int[stack.size()];
        for(int i=ans.length - 1; i>=0; i--)
            ans[i]=stack.pop();
        return ans;
        
    }
}
