class Solution {

    int left = 0 , right = 0;

    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(char ch : s1.toCharArray()) {
            ++arr1[ch - 'a'];
        }
        
        while(right < s2.length()) {
            ++arr2[s2.charAt(right) - 'a'];
            if((right - left + 1) > s1.length()) {
                //System.out.println("Length exceeded");
                --arr2[s2.charAt(left) - 'a'];
                left++;
            }
            if((right - left + 1) == s1.length()
             && isPermutation(arr1, arr2)) {
                //System.out.println("Right: " + right + " Left: " + left);
                return true;
            }
            right++;
        }
        return false;
    }

    private boolean isPermutation(int[] arr1, int[] arr2) {
        //System.out.println("Right: " + right + " Left: " + left);
        for(int index = 0 ; index < 26 ; index++) {
            if(arr1[index] != arr2[index]) {
                return false;
            }
        }
        return true;
    }


}
