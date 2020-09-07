class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         if (s == null || s.length() == 0) 
//             return false;
        
//         int n = s.length();

//         // dp[i] represents whether s[0...i] can be formed by wordDict
//         boolean[] dp = new boolean[n];

//          for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= i; j++) {
//                 String sub = s.substring(j, i + 1);

//                 if (wordDict.contains(sub) && (j == 0 || dp[j - 1])) {
//                     dp[i] = true;
//                     break;
//                 }
//             }
//         }
        
//         return dp[n - 1];
//     }
    
    
    public static class TrieNode {
        boolean isWord;
        TrieNode[] c;
        
        public TrieNode(){
            isWord = false;
            c = new TrieNode[128];
        }
    }
    
    public void addWord(TrieNode t, String w) {
        for (int i = 0; i < w.length(); i++) {
            int j = (int)w.charAt(i); 
            if (t.c[j] == null) t.c[j] = new TrieNode();
            t = t.c[j];
        }
        t.isWord = true;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode t = new TrieNode(), cur;
        for (String i : wordDict) 
            addWord(t, i);
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[] f = new boolean[len + 1];
        f[len] = true;
        
        for (int i = len - 1; i >= 0; i--) {
            //System.out.println(str[i]);
            cur = t;
            for (int j = i; cur != null && j < len ; j++) {
                cur = cur.c[(int)str[j]];
                if (cur != null && cur.isWord && f[j + 1]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[0];
    } 
    
}
