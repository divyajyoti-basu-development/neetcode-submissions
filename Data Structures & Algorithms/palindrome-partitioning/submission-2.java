class Solution {

    private boolean isPalindrome(StringBuilder sb) {
        //if (sb.length() == 0) return false;

        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    private void solve(String s, int index,
                       List<List<String>> result,
                       List<String> current) {

        // If at the end, add result
        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        StringBuilder sb = new StringBuilder();

        // Build substring s[index..i]
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (isPalindrome(sb)) {
                current.add(sb.toString());
                solve(s, i + 1, result, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(s, 0, result, new ArrayList<>());
        return result;
    }
}
