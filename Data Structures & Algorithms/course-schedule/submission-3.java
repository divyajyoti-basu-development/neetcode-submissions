class Solution {

    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Set<Integer> visitSet = new HashSet<>();

    private boolean dfs(int course) {
        if(!adjList.containsKey(course)) {
            return true;
        }
        if(adjList.get(course) == null) {
            return true;
        }
        if(visitSet.contains(course)) {
            return false;
        }
        visitSet.add(course);
        for(Integer requiredCourse : adjList.get(course)) {
            if(!dfs(requiredCourse)) {
                return false;
            }
        }
        adjList.put(course, null);
        visitSet.remove(course);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] coursePair : prerequisites) {
            if(!adjList.containsKey(coursePair[0])) {
                adjList.put(coursePair[0], new ArrayList<>());
            } adjList.get(coursePair[0]).add(coursePair[1]);
        }  
        for(int[] coursePair : prerequisites) {
            if(!dfs(coursePair[0])) {
                return false;
            }
        }   
        return true;  
    }

    
}
