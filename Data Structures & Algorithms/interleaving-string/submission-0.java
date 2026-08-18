class Solution {

    private boolean solve(String s1, String s2, int index1, int index2, String s3, int index3) {
        if(index3 == s3.length()) {
            return true;
        }
        if(index1 == s1.length() && (s3.length() - index3 - s2.length() + index2) != 0) {
            return false;
        }
        if(index2 == s2.length() && (s3.length() - index3 - s1.length() + index1) != 0) {
            return false;
        }
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            if(solve(s1, s2, index1 + 1, index2, s3, index3 + 1)) {
                return true;
            }
        }
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
            if(solve(s1, s2, index1, index2 + 1, s3, index3 + 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return solve(s1, s2, 0, 0, s3, 0);
    }
    
}
