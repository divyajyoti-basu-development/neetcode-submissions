class Solution {

    private boolean canFinish(int currentCourse, List<Integer> dependencies
    , Map<Integer, List<Integer>> dependencyMap, Set<Integer> visited, Set<Integer> finished) {
        if(finished.contains(currentCourse)) {
            return true;
        }
        if(visited.contains(currentCourse)) {
            return false;
        }
        visited.add(currentCourse);
        for(int dependency : dependencies) {
            if(!canFinish(dependency, dependencyMap.get(dependency), dependencyMap, visited, finished)) {
                return false;
            }
        }
        finished.add(currentCourse);
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> finished = new LinkedHashSet<>();
        Map<Integer, List<Integer>> dependencyMap = new HashMap<>();
        for(int course = 0 ; course < numCourses ; course++) {
            dependencyMap.put(course, new ArrayList<>());
        }
        for(int[] preReq : prerequisites) {
            dependencyMap.get(preReq[0]).add(preReq[1]);
        }
        for(int course = 0 ; course < numCourses ; course++) {
            if(!visited.contains(course) && !canFinish(course, dependencyMap.get(course)
            , dependencyMap, visited, finished)) {
                return new int[] {};
            }
        }
        return new ArrayList<>(finished).stream()
                                   .mapToInt(i -> i)
                                   .toArray();
    }
}
