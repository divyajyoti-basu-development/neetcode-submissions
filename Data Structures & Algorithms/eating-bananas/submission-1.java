class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPileSize = 0;
        for(int pile : piles) {
            maxPileSize = Math.max(maxPileSize, pile);
        }
        int minSpeed = 0, left = 1, right = maxPileSize, mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(canEat(mid, piles, h)) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }

    private boolean canEat(int speed, int[] piles, int timeLimit) {
        double totalTime = 0;
        for(int pile : piles) {
            totalTime = totalTime + Math.ceil((double)pile / speed);
        }
        return totalTime <= timeLimit ? true : false;
    }

}
