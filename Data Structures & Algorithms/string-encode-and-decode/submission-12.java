class Solution {

    private String lengthCounter;

    public String encode(List<String> strs) {
        StringBuilder sb1 = new StringBuilder("");
        StringBuilder sb2 = new StringBuilder("");
        for(String str : strs) {
            sb1.append(str.length());
            sb1.append("#");
            sb2.append(str);
        }
        lengthCounter = sb1.toString();
        //System.out.println("Length String: " + sb1.toString());
        //System.out.println("Encoded String: " + sb2.toString());
        return sb2.toString();
    }

    public List<String> decode(String str) {
        if(lengthCounter.length() == 0) {
            return new ArrayList<>();
        }
        //System.out.print("Input String: " + str);
        int startIndex = 0;
        //String test = str.substring(8, 4);
        List<String> result = new ArrayList<>();
        String[] lengthArr = lengthCounter.split("#");
        for(String length : lengthArr) {
            //System.out.println("Start Index: " + startIndex);
            //System.out.println("Length: " + length);
            result.add(str.substring(startIndex, startIndex + Integer.valueOf(length)));
            startIndex = startIndex + Integer.valueOf(length);
        }
        return result;
    }
}
