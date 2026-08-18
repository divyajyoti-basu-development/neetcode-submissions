class Solution {
    
    private class Task {
        int enQueueTime;
        int processingTime;
        int index;

        Task(int enQueueTime, int processingTime, int index) {
            this.enQueueTime = enQueueTime;
            this.processingTime = processingTime;
            this.index = index;
        }

        int getEnqTime() {
            return enQueueTime;
        }

        int getProcessingTime() {
            return processingTime;
        }

        int getIndex() {
            return index;
        }

    }

    public int[] getOrder(int[][] tasks) {
        Queue<Task> taskMinHeap = new PriorityQueue<>(Comparator.comparing(Task :: getProcessingTime).thenComparing(Task :: getIndex));
        int index = 0;
        Queue<Task> enqTimeMinHeap = new PriorityQueue<>(Comparator.comparing(Task :: getEnqTime));
        for(int[] task : tasks) {
            enqTimeMinHeap.offer(new Task(task[0], task[1], index++));
        }        
        List<Integer> result = new ArrayList<>();
        int currentTime = 0;
        Task currentTask;
        while(!enqTimeMinHeap.isEmpty()) {
            if(currentTime >= enqTimeMinHeap.peek().getEnqTime()) {
                while(!enqTimeMinHeap.isEmpty() && currentTime >= enqTimeMinHeap.peek().getEnqTime()) {
                    taskMinHeap.offer(enqTimeMinHeap.poll());
                }
                if(!taskMinHeap.isEmpty()) {
                    currentTask = taskMinHeap.poll();
                    result.add(currentTask.getIndex());
                    currentTime = currentTime + currentTask.getProcessingTime();
                }
            } else {
                currentTime++;
            }
        }
        while(!taskMinHeap.isEmpty()) {
            currentTask = taskMinHeap.poll();
            result.add(currentTask.getIndex());
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}