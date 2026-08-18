class Solution {

    private void solve(Map<String, List<String>> digitsMap, String[] digits, int index, StringBuilder sb, List<String> result) {
        if(index == digits.length) {
            result.add(sb.toString().toLowerCase());
            return;
        }
        for(String letter : digitsMap.get(digits[index])) {
            sb.append(letter);
            solve(digitsMap, digits, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> digitsMap = new HashMap<>();
        String[] digitsArr = digits.split("");
        List<String> result = new ArrayList<>();
        digitsMap.put("2", List.of("A", "B", "C"));
        digitsMap.put("3", List.of("D", "E", "F"));
        digitsMap.put("4", List.of("G", "H", "I"));
        digitsMap.put("5", List.of("J", "K", "L"));
        digitsMap.put("6", List.of("M", "N", "O"));
        digitsMap.put("7", List.of("P", "Q", "R", "S"));
        digitsMap.put("8", List.of("T", "U", "V"));
        digitsMap.put("9", List.of("W", "X", "Y", "Z"));
        solve(digitsMap, digitsArr, 0, new StringBuilder(), result);
        return result;
    }
}
