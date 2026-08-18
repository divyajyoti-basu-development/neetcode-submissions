class Solution {

    private void solve(StringBuilder sb, int length, int openCount, int closeCount, List<String> result) {
        if(openCount > length || closeCount > openCount) {
            return;
        }
        if(openCount + closeCount == length * 2) {
            result.add(sb.toString());
            return;
        }
        sb.append("(");
        solve(sb, length, openCount + 1, closeCount, result);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        solve(sb, length, openCount, closeCount + 1, result);
        sb.deleteCharAt(sb.length() - 1);        
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder("");
        List<String> result = new ArrayList<>();
        solve(sb, n, 0, 0, result);
        return result;
    }
}
