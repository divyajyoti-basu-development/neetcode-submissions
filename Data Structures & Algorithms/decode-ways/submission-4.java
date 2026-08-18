class Solution {

    //private int result;    

    private int recursiveDecode(String s, int index, boolean isSecond, char prev) {
        if(isSecond == false && index == s.length()) {
            return 1;
        }
        if(index >= s.length() || isSecond == false && s.charAt(index) == '0') {
            return 0;
        }
        // if(index == s.length() - 1) {
        //     return 1;
        // }
        if(isSecond == true && prev == '2' && s.charAt(index) - '0' > 6) {
            return 0;
        } 
        int result1 = 0;
             
        result1 = recursiveDecode(s, index + 1, false, 'n');
        
        //result1 = result1 == 0 ? 0 : result1;
        int result2 = 0;
        if(isSecond == false && s.charAt(index) - '0' < 3) {
            result2 = recursiveDecode(s, index + 1, true, s.charAt(index));
            //result2 = result2 == 0 ? 0 : 1 + result2;
        }
        
        return result1 + result2;
    }
    public int numDecodings(String s) {
        if(s.length() == 1 && s.charAt(0) != '0') {
            return 1;
        }
        return recursiveDecode(s, 0, false, 'n');
    }
}