class TrieNode {
    public boolean isWord; 
    public TrieNode[] children = new TrieNode[26];
}

class Trie {
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) 
                return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root; 
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) 
                return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}




// class TrieNode {

//     // R links to node children
//     private TrieNode[] links;

//     private final int R = 26;

//     private boolean isEnd;

//     public TrieNode() {
//         links = new TrieNode[R];
//     }

//     public boolean containsKey(char ch) {
//         return links[ch -'a'] != null;
//     }
//     public TrieNode get(char ch) {
//         return links[ch -'a'];
//     }
//     public void put(char ch, TrieNode node) {
//         links[ch -'a'] = node;
//     }
//     public void setEnd() {
//         isEnd = true;
//     }
//     public boolean isEnd() {
//         return isEnd;
//     }
// }


// class Trie {
    
//     private TrieNode root;

//     /** Initialize your data structure here. */
//     public Trie() {
//         root = new TrieNode();
//     }
    
//     /** Inserts a word into the trie. */
//     public void insert(String word) {
//         TrieNode node = root;
//         for (int i = 0; i < word.length(); i++) {
//             char currentChar = word.charAt(i);
//             if (!node.containsKey(currentChar)) {
//                 node.put(currentChar, new TrieNode());
//             }
//             node = node.get(currentChar);
//         }
//         node.setEnd();
//     }
    
//     /** Returns if the word is in the trie. */
//     public boolean search(String word) {
//         TrieNode node = searchPrefix(word);
//         return node != null && node.isEnd();
//     }
    
//     private TrieNode searchPrefix(String word) {
//         TrieNode node = root;
//         for (int i = 0; i < word.length(); i++) {
//            char curLetter = word.charAt(i);
//            if (node.containsKey(curLetter)) {
//                node = node.get(curLetter);
//            } else {
//                return null;
//            }
//         }
//         return node;
//     }
    
//     /** Returns if there is any word in the trie that starts with the given prefix. */
//     public boolean startsWith(String prefix) {
//         TrieNode node = searchPrefix(prefix);
//         return node != null;
//     }
// }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
