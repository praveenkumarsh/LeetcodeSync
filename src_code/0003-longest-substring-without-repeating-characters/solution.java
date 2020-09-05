class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        int ans = 0;
        
        for(int j=0,i=0;j<s.length();j++){
            i = Math.max(index[s.charAt(j)], i);    //Set starting point of current non repeating substring 
            ans = Math.max(ans, j - i + 1);         //longest substring length
            
            index[s.charAt(j)] = j+1; //Set last location of current character (if repeated)
        }
        return ans;
        
    }
}

