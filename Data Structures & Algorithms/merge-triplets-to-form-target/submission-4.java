class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> targetPos = new HashSet<>();
        for(int index = 0 ; index < triplets.length ; index++) {
            if(triplets[index][0] > target[0] 
            || triplets[index][1] > target[1]
            || triplets[index][2] > target[2]) {
                continue;
            }
            if(triplets[index][0] == target[0]) {
                targetPos.add(0);
            }
            if(triplets[index][1] == target[1]) {
                targetPos.add(1);
            }
            if(triplets[index][2] == target[2]) {
                targetPos.add(2);
            }
        }
        return targetPos.size() < 3 ? false : true;
    }
}