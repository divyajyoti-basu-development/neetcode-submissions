class Solution {
    
    private int getDecodeWays(String s, int index, int[] memo) {
        if(index == s.length()) {
            return 1;
        }
        if(s.charAt(index) == '0') {
            return 0;
        }        
        if(memo[index] != -1) {
            return memo[index];
        }               
        int count1 = 0;        
        int count2 = 0;
        if(index + 1 < s.length()          
         &&
         ((s.charAt(index) == '2' && s.charAt(index + 1) < '7')
          || (s.charAt(index) == '1' && s.charAt(index + 1) <= '9'))       
         
         ) {
            count2 = getDecodeWays(s, index + 2, memo);
        }
        
            count1 = getDecodeWays(s, index + 1, memo);
        
        return memo[index] = count1 + count2;
    }

    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return getDecodeWays(s, 0, memo);
    }
}
