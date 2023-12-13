class StreamChecker {
    TrieNode root;
    StringBuilder sb; 
    public StreamChecker(String[] words) {
        root = new TrieNode(); 
        sb = new StringBuilder(); 

        // building trie
        for(int i=0; i<words.length; i++){
            insert(root, words[i]); 
        }
    }
    
    public boolean query(char letter) {
        return isPresent(letter); 
    }

    private void insert(TrieNode root, String str){
        TrieNode current = root;
        for(int i=str.length()-1; i>=0; i--){
            char c = str.charAt(i);
            if(current.children[c-'a'] == null){
                current.children[c-'a'] = new TrieNode(); 
            }
            current = current.children[c-'a']; 
        }
        current.isEOW = true; 
    }

    private boolean isPresent(char letter){
        TrieNode curr = root; 
        sb.append(letter);
        
        for(int i=sb.length()-1; i >=0; i--){
            char c = sb.charAt(i);
            if(curr.children[c-'a'] == null){
                return false; 
            } else {
                curr = curr.children[c-'a'];
                if(curr.isEOW) return true;
            }
        }
        return false; 
    }

    class TrieNode{
        TrieNode[] children;
        boolean isEOW; 

        public TrieNode(){
            isEOW = false; 
            children = new TrieNode[26];
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
