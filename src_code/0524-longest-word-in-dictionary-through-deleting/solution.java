class Solution {
    public static String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));

        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                return word;
            }
        }

        return "";
    }

    private static boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }
}
