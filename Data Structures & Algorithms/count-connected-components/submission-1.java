class Solution {

    private void dfsTraverse(Map<Integer, List<Integer>> adjList, int point, Set<Integer> visited) {
        if(visited.contains(point)) {
            return;
        }
        visited.add(point);
        for(Integer direction : adjList.get(point)) {
            dfsTraverse(adjList, direction, visited);
        }
    }

    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int point = 0 ; point < n ; point++) {
            adjList.put(point, new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        n--;
        while(n != -1) {
            if(!visited.contains(n)) {
                count++;
                dfsTraverse(adjList, n, visited);
            }
            n--;
        }
        return count;
    }
}
