class Solution {

    private Map<Character, List<Character>> digitLetterMap;

    private void solve(String s, int index, List<String> result, StringBuilder current) {
        if(index == s.length()) {
            result.add(current.toString());
            return;
        }
        char ch = s.charAt(index);
        for(Character letter : digitLetterMap.get(ch)) {
            current.append(letter);
            solve(s, index + 1, result, current);
            current.deleteCharAt(current.length() - 1);
        }        
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        digitLetterMap = new HashMap<>();
        digitLetterMap.put('2', List.of('a', 'b', 'c'));
        digitLetterMap.put('3', List.of('d', 'e', 'f'));
        digitLetterMap.put('4', List.of('g', 'h', 'i'));
        digitLetterMap.put('5', List.of('j', 'k', 'l'));
        digitLetterMap.put('6', List.of('m', 'n', 'o'));
        digitLetterMap.put('7', List.of('p', 'q', 'r', 's'));
        digitLetterMap.put('8', List.of('t', 'u', 'v'));
        digitLetterMap.put('9', List.of('w', 'x', 'y', 'z'));
        List<String> result = new ArrayList<>();
        solve(digits, 0, result, new StringBuilder(""));
        return result;
    }
}
