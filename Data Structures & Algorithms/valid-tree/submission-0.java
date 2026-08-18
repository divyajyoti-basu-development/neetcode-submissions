class Solution {

    public boolean isTree(int node, int prev, List<Integer> neighbours, Set<Integer> visited
    , Map<Integer, List<Integer>> graphMap) {
        //System.out.println("Checking for node: " + node + " Prev: " + prev);        
        if(visited.contains(node)) {            
            return false;
        }
        visited.add(node);
        for(int neighbour : neighbours) {
            if(neighbour == prev) {
                continue;
            }
            if(!isTree(neighbour, node, graphMap.get(neighbour), visited, graphMap)) {
                return false;
            }
        }               
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        for(int node = 0 ; node < n ; node++) {
            graphMap.put(node, new ArrayList<>());
        }
        for(int[] edge : edges) {
            graphMap.get(edge[0]).add(edge[1]);
            graphMap.get(edge[1]).add(edge[0]);
        }
        int componentsCount = 0;
        for(int node = 0 ; node < n ; node++) {
            if(!visited.contains(node)) {
                if(!isTree(node, 101, graphMap.get(node), visited, graphMap)) {
                    return false;
                }
                componentsCount++;
            }
        }
        return componentsCount == 1 ? true : false;
    }
}
