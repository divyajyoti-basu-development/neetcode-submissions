class Solution {

    public boolean canComplete(int currentCourse, List<Integer> dependencies, Map<Integer, List<Integer>> courseDependencyMap
    , Set<Integer> visited, Set<Integer> completed) {
        if(completed.contains(currentCourse)) {
            return true;
        }
        if(visited.contains(currentCourse)) {
            return false;
        }
        visited.add(currentCourse);
        for(int dependency : dependencies) {
            if(!canComplete(dependency, courseDependencyMap.get(dependency), courseDependencyMap, visited, completed)) {
                return false;
            }
        }
        completed.add(currentCourse);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> completed = new HashSet<>();
        Map<Integer, List<Integer>> courseDependencyMap = new HashMap<>();        
        for(int courseNo = 0 ; courseNo < numCourses ; courseNo++) {
            courseDependencyMap.put(courseNo, new ArrayList<>());
        }
        for(int[] prerequisitePair : prerequisites) {
            courseDependencyMap.get(prerequisitePair[0]).add(prerequisitePair[1]);
        }        
        for(int courseNo = 0 ; courseNo < numCourses ; courseNo++) {
            if(!visited.contains(courseNo) && !canComplete(courseNo, courseDependencyMap.get(courseNo)
            , courseDependencyMap, visited, completed)) {
                return false;
            }
        }
        return true;
    }
}
