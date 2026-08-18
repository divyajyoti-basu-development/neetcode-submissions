class Solution {

    private void solve(int count, int open, int close, List<String> result, StringBuilder sb) {
        if(close > open) {
            return;
        }
        if(close == open && close == count) {
            result.add(sb.toString());
            return;
        }
        if(open > count || close > count) {
            return;
        }
        sb.append("(");        
        solve(count, open + 1, close, result, sb);
        sb.deleteCharAt(sb.length() - 1);        
        sb.append(")");        
        solve(count, open, close + 1, result, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        solve(n, 0, 0, result, sb);
        return result;
    }

}
