class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0].split("\\+")[0].replace(".", "");
            String normalizedEmail = local + "@" + parts[1];
            uniqueEmails.add(normalizedEmail);
        }

        return uniqueEmails.size();
    }
}
