class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = Arrays.stream(strs)
        .collect(Collectors.groupingBy(str -> {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            return new String(chArr);
        }));
        List<List<String>> result = new ArrayList<>();
        for(List<String> list:  anagramsMap.values()) {
            result.add(list);
        }
        return result;
    }
}
