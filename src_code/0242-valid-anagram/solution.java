class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            arr[ch1-'a']++;
            arr[ch2-'a']--;
        }
        
        for(int val:arr){
            if(val!=0){
                return false;
            }
        }
        
        return true;
    }
}
