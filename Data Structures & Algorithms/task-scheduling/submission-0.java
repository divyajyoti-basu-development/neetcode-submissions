class Solution {

    private class Task {
        int count;
        int enqTime;

        Task(int count, int enqTime) {
            this.count = count;
            this.enqTime = enqTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Character, Integer> countMap = new HashMap<>();
        for(char ch : tasks) {
            if(countMap.containsKey(ch)) {
                countMap.put(ch, countMap.get(ch) + 1);
            } else {
                countMap.put(ch, 1);
            }
        }
        countMap.forEach((k, v) -> maxHeap.offer(v));
        Queue<Task> taskQ = new ArrayDeque<>();
        int currentTime = 0;
        int index = 0;
        Task scheduledTask;
        while(!maxHeap.isEmpty() || !taskQ.isEmpty()) {
            while(!taskQ.isEmpty() && taskQ.peek().enqTime <= currentTime) {
                maxHeap.offer(taskQ.poll().count);      
            }
            if(!maxHeap.isEmpty()) {
                index++;
                currentTime++;
                if(maxHeap.peek() == 1) {
                    maxHeap.poll();                    
                }
                else {                
                    scheduledTask = new Task(maxHeap.poll() - 1, currentTime + n);
                    taskQ.offer(scheduledTask); 
                }               
            } else {
                currentTime++;
            }
        }
        return currentTime;
    }

}