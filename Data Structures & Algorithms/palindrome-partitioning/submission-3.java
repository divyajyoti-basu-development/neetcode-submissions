class Solution {

    private boolean isPalindrome(StringBuilder sb) {
        if (sb.length() == 0) return false;
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    private void solve(String s, int index, 
                       StringBuilder sb,
                       List<String> current,
                       List<List<String>> result) {

        // If at the end of string, check last piece
        if (index == s.length()) {
            if (isPalindrome(sb)) { 
                current.add(sb.toString());
                result.add(new ArrayList<>(current));
                current.remove(current.size() - 1);
            }
            return;
        }

        // ─────────────────────────────────────────────
        // BRANCH 1: If sb is a palindrome, split here
        // ─────────────────────────────────────────────
        if (isPalindrome(sb)) {
            current.add(sb.toString());

            // Start a NEW substring with s[index]
            StringBuilder next = new StringBuilder();
            next.append(s.charAt(index));

            solve(s, index + 1, next, current, result);

            current.remove(current.size() - 1);
        }

        // ─────────────────────────────────────────────
        // BRANCH 2: Continue extending current substring
        // ─────────────────────────────────────────────
        sb.append(s.charAt(index));
        solve(s, index + 1, sb, current, result);
        sb.deleteCharAt(sb.length() - 1); // backtrack
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        solve(s, 1, sb, current, result);

        return result;
    }
}
