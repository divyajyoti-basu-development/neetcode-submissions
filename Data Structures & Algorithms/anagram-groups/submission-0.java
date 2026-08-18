class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> containerMap = new HashMap<>();
        String temp;
        for(String s : strs) {
            temp = s.chars().mapToObj(c -> String.valueOf(c)).sorted().collect(Collectors.joining(""));
            if(!containerMap.containsKey(temp)) {
                containerMap.put(temp, new ArrayList<>());
            }
            containerMap.get(temp).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        containerMap.forEach((k, v) -> result.add(v));
        return result;
    }
}
