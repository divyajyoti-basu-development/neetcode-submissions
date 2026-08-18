class Solution {
    public boolean isAnagram(String s, String t) {
        s = s.toLowerCase().chars().sorted().mapToObj(String :: valueOf)
        .collect(Collectors.joining(""));
        t = t.toLowerCase().chars().sorted().mapToObj(String :: valueOf)
        .collect(Collectors.joining(""));
        return s.equals(t) ? true : false;
    }
}
