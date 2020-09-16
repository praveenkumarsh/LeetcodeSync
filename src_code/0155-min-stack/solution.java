class MinStack {
    
    int min;
    Stack<Integer> stack;//value-min-value-min-................

    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    //[-2,0,-3]
    
    //       |infi, -2,| 0, | -2, -3 |
    
    //min>>  |-(-2)----|(-2)|--(-3)--|
    
    //// only push the old minimum value when the current 
    // minimum value changes after pushing the new value x
    public void push(int x) {
        if(min>=x){
            stack.push(min);
            min = x;
        }
        
        stack.push(x);
        
    }
    
    //// if pop operation could result in the changing of the current minimum value, 
    // pop twice and change the current minimum value to the last minimum value.
    public void pop() {
        if(stack.pop()==min){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
