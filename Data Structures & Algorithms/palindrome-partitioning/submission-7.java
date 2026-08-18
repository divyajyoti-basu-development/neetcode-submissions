class Solution {

    private boolean isPalindrome(StringBuilder sb) {
        int left = 0, right = sb.length() - 1;
        while(left <= right) {
            if(sb.charAt(left++) != sb.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    private void solve(String s, StringBuilder sb, int index, List<List<String>> result, List<String> current) {
        if(s.length() == index) {
            if(isPalindrome(sb)) { 
                current.add(sb.toString());
                result.add(new ArrayList<>(current));
                current.remove(current.size() - 1);
                return;
            }
            return;
        }
        if(isPalindrome(sb)) {
            current.add(sb.toString());
            solve(s, new StringBuilder("").append(s.charAt(index)), index + 1, result, current);
            current.remove(current.size() - 1);
        }
        sb.append(s.charAt(index));          
        solve(s, sb, index + 1, result, current);        
        sb.deleteCharAt(sb.length() - 1);     
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        solve(s, new StringBuilder("").append(s.charAt(0)), 1, result, current);
        return result;
    }
}
