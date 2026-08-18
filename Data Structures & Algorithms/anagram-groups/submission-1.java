class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        String temp;
        for(String str : strs) {
            temp = str.chars().sorted().mapToObj(String :: valueOf).collect(Collectors.joining(""));
            if(anagramsMap.containsKey(temp)) {
                anagramsMap.get(temp).add(str);
            } else {
                anagramsMap.put(temp, new ArrayList<>() {
                    { add(str); }
                });
            }
        }
        List<List<String>> result = new ArrayList<>();
        anagramsMap.forEach((k, v) -> result.add(v));
        return result;
    }
}
