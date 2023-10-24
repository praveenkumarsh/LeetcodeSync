class Solution {
	public int expressiveWords(String S, String[] words) {
		int count = 0;

		for (String word : words) {
			if (isStretchy(S, word)) {
				count++;
			}
		}

		return count;
	}

	private boolean isStretchy(String S, String word) {
		int i = 0, j = 0;

		while (i < S.length() && j < word.length()) {
			if (S.charAt(i) == word.charAt(j)) {
				int countS = 0;
				int countWord = 0;

				char charS = S.charAt(i);
				char charWord = word.charAt(j);

				// Count repeating characters in S
				while (i < S.length() && S.charAt(i) == charS) {
					countS++;
					i++;
				}

				// Count repeating characters in word
				while (j < word.length() && word.charAt(j) == charWord) {
					countWord++;
					j++;
				}

				// Check if the stretchy condition is met
				if (countS < 3 && countS != countWord) {
					return false;
				}

				if (countS < countWord) {
					return false;
				}
			} else {
				return false;
			}
		}

		return i == S.length() && j == word.length();
	}
}
