class Solution {
    private final Map<String, List<String>> cache = new HashMap<>();

    private boolean containsSuffix(Set<String> dict, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (dict.contains(str.substring(i))) return true;
        }
        return false;
    }

    public List<String> wordBreak(String s, List<String> dictList) {
        Set<String> dict = new HashSet<>();
        for(String val : dictList){
            dict.add(val);
        }
        return wordBreak(s,dict);
    }
    
    public List<String> wordBreak(String s, Set<String> dict) {
        
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        
        List<String> result = new LinkedList<>();
        
        if (dict.contains(s)){
            result.add(s);
        }
        
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0,i), right = s.substring(i);
            if (dict.contains(left) && containsSuffix(dict, right)) {
                for (String ss : wordBreak(right, dict)) {
                    result.add(left + " " + ss);
                }
            }
        }
        cache.put(s, result);
        return result;
    }
}
