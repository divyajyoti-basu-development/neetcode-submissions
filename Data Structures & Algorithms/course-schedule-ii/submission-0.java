class Solution {

    private boolean dfsGetScheduleOrder(Map<Integer, List<Integer>> adjList
    , int courseNo, Set<Integer> visited, Set<Integer> finished
    ) {
        if(finished.contains(courseNo)) {
            return true;
        }
        if(visited.contains(courseNo)) {
            return false;
        }
        visited.add(courseNo);
        for(Integer dependency : adjList.get(courseNo)) {
            if(!dfsGetScheduleOrder(adjList, dependency, visited, finished)) {
                return false;
            }
        }
        finished.add(courseNo);
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int courseNo = 0 ; courseNo < numCourses ; courseNo++) {
            adjList.put(courseNo, new ArrayList<>()); 
        }
        for(int[] coursePair : prerequisites) {
            adjList.get(coursePair[0]).add(coursePair[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> finished = new LinkedHashSet<>();
        for(int courseNo = 0 ; courseNo < numCourses ; courseNo++) {
            if(!dfsGetScheduleOrder(adjList, courseNo, visited, finished)) {
                return new int[] {};
            }
        }
        return finished.stream().mapToInt(Integer :: valueOf).toArray();
    }

}
