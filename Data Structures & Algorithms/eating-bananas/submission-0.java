class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for(int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }
        int minSpeed = 1;
        int midSpeed;
        int result = 0;
        while(minSpeed <= maxSpeed) {
            midSpeed = (minSpeed + maxSpeed) / 2;
            if(canEat(midSpeed, piles, h)) {
                result = midSpeed;
                maxSpeed = midSpeed - 1;
            } else {
                minSpeed = midSpeed + 1;
            }
        }
        return result;
    }

    private boolean canEat(int speed, int[] piles, int maxTime) {
        int totalTime = 0;
        for(int pile : piles) {
            totalTime = totalTime + (int)Math.ceil((double)pile/speed);
        }
        return totalTime <= maxTime;
    }
}
