class Solution {

    private boolean dfsCanFinish(Map<Integer, List<Integer>> adjList
    , int courseNo, Set<Integer> visited, Set<Integer> finished) {
        if(finished.contains(courseNo)) {
            return true;
        }
        if(visited.contains(courseNo)) {
            return false;
        }
        visited.add(courseNo);
        for(Integer dependency : adjList.get(courseNo)) {
            if(!dfsCanFinish(adjList, dependency, visited, finished)) {
                return false;
            }
        }
        finished.add(courseNo);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] dependencyPair : prerequisites) {
            if(adjList.containsKey(dependencyPair[0])) {
                adjList.get(dependencyPair[0]).add(dependencyPair[1]);                
            } else {
                adjList.put(dependencyPair[0], new ArrayList<>() {
                    { add(dependencyPair[1]); }
                });           
            }
            if(!adjList.containsKey(dependencyPair[1])) {
                    adjList.put(dependencyPair[1], new ArrayList<>());
            }
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> finished = new HashSet<>();
        for(Map.Entry<Integer, List<Integer>> entries : adjList.entrySet()) {
            if(!dfsCanFinish(adjList, entries.getKey(), visited, finished)) {
                return false;
            }
        }
        return true;
    }
}
