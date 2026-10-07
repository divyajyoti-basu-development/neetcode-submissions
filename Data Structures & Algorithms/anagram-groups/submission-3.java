class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        int[] countArr = new int[26];
        for(String str : strs) {
            for(char ch : str.toCharArray()) {
                countArr[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int count : countArr) {
                sb.append(count);
                sb.append("#");
            }
            Arrays.fill(countArr, 0);
            String key = sb.toString();
            if(result.get(key) == null) {
                result.put(key, new ArrayList<>() {
                    { add(str); }
                });
            } else {
                result.get(key).add(str);
            }
        }
        return new ArrayList<>(result.values());
    }
}
