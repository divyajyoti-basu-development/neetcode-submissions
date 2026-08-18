class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0, sumCost = 0;
        for(int fuel : gas) {
            sumGas += fuel;
        }
        for(int stationCost : cost) {
            sumCost += stationCost;
        }
        if(sumCost > sumGas) {
            return -1;
        }
        int[] reserveFuels = new int[gas.length];        
        for(int index = 0 ; index < gas.length ; index++) {
            reserveFuels[index] = gas[index] - cost[index];
        }
        int startIndex = 0, currentMaxFuel = 0;
        for(int index = 0 ; index < reserveFuels.length ; index++) {
            if(currentMaxFuel + gas[index] - cost[index] <= 0) {
                currentMaxFuel = 0;
            }
            else if(reserveFuels[index] > 0 && currentMaxFuel == 0) {
                currentMaxFuel = reserveFuels[index];
                startIndex = index;
            }
        }
        return startIndex;
    }
}
