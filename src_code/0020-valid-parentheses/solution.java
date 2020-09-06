class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.size()>0&&mappings.get(ch)==st.peek())
                st.pop();
            
//             if(st.size()>0&&ch==')'&&st.peek()=='(')
//                 st.pop();
//             else if(st.size()>0&&ch==']'&&st.peek()=='[')
//                 st.pop();
//             else if(st.size()>0&&ch=='}'&&st.peek()=='{')
//                 st.pop();
                
            else{
                st.push(ch);
            }
        }
        
        return st.size()==0?true:false;
        
    }
}
