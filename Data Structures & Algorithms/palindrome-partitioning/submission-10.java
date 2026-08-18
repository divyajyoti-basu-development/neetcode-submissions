class Solution {

    private boolean isPalindrome(String s, int index1, int index2) {
        while(index1 < index2) {
            if(s.charAt(index1) != s.charAt(index2)) {
                return false;
            }
            index1++;
            index2--;
        }
        return true;
    }

    private void solve(String s, int index, List<String> current, List<List<String>> result) {
        if(index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int pos = index ; pos < s.length() ; pos++) {
            sb.append(s.charAt(pos));
            if(isPalindrome(s, index, pos)) {                
                current.add(sb.toString());
                solve(s, pos + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        solve(s, 0, current, result);
        return result;
    }
}
