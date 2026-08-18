class Solution {

    private boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private void solve(String s, int index, List<List<String>> result, List<String> current) {
        if(index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int position = index ; position < s.length() ; position++) {
            if(isPalindrome(s, index, position)) {
                current.add(s.substring(index, position + 1));
                solve(s, position + 1, result, current);
                current.remove(current.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        solve(s, 0, result, current);
        return result;
    }

}
