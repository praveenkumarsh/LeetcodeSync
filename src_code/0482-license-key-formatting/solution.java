class Solution {
     public static String licenseKeyFormatting(String s, int k) {
        // Remove dashes and convert to uppercase
        s = s.replace("-", "").toUpperCase();
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        // Determine the length of the first group
        int firstGroupLength = n % k;
        if (firstGroupLength > 0) {
            sb.append(s.substring(0, firstGroupLength));
            if (firstGroupLength != n) {
                sb.append("-");
            }
        }

        // Add subsequent groups of size 'k' with dashes
        for (int i = firstGroupLength; i < n; i += k) {
            sb.append(s.substring(i, i + k));
            if (i + k != n) {
                sb.append("-");
            }
        }

        return sb.toString();
    }
}
