class Solution {
	public boolean backspaceCompare(String s, String t) {
		int i = s.length() - 1;
		int j = t.length() - 1;
		int skipS = 0;
		int skipT = 0;

		while (i >= 0 || j >= 0) {
			// Skip backspace characters and characters they affect in s
			while (i >= 0) {
				if (s.charAt(i) == '#') {
					skipS++;
					i--;
				} else if (skipS > 0) {
					skipS--;
					i--;
				} else {
					break;
				}
			}

			// Skip backspace characters and characters they affect in t
			while (j >= 0) {
				if (t.charAt(j) == '#') {
					skipT++;
					j--;
				} else if (skipT > 0) {
					skipT--;
					j--;
				} else {
					break;
				}
			}

			// Check if the current characters are equal
			if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
				return false;
			}

			// If one string has characters left and the other doesn't, they are not equal
			if ((i >= 0 && j < 0) || (i < 0 && j >= 0)) {
				return false;
			}

			i--;
			j--;
		}

		return true;
	}
}
