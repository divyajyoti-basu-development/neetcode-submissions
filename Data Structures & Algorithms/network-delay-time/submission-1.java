class Solution {

    private class Node {

        int weight;
        int point;       

        int getWeight() {
            return weight;
        }

        int getPoint() {
            return point;
        }

        void setWeight(int newWeight) {
            this.weight = newWeight;
        }

        public String toString() {
            return "{ point: " + this.point + " weight: " + this.weight + " }";
        }

        Node(int point, int weight) {
            this.weight = weight;
            this.point = point;
        }

    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> visited = new HashSet<>();
        Queue<Node> minHeap = new PriorityQueue<>(Comparator.comparing(Node :: getWeight));
        Map<Integer, List<Node>> adjList = new HashMap<>();
        int source, target;
        for(int[] edge : times) {
            source = edge[0];            
            if(adjList.containsKey(source)) {
                adjList.get(source).add(new Node(edge[1], edge[2]));
            } else {
                adjList.put(source, new ArrayList<>() {
                    { add(new Node(edge[1], edge[2])); }
                });
            }
        }
        System.out.println("AjdList: " + adjList);
        int totalTime = 0;
        minHeap.offer(new Node(k, 0));
        Node currentNode;
        while(!minHeap.isEmpty()) {
            currentNode = minHeap.poll();                        
            if(visited.contains(currentNode.getPoint())) {
                continue;
            }
            System.out.println("Visiting node: " + currentNode.getPoint() + " with time: " + currentNode.getWeight());
            visited.add(currentNode.getPoint());
            totalTime = Math.max(totalTime, currentNode.getWeight());
            if(adjList.get(currentNode.getPoint()) == null) {
                continue;
            }            
            for(Node neighbor : adjList.get(currentNode.getPoint())) {
                if(!visited.contains(neighbor.getPoint())) {
                    int newDist = currentNode.getWeight() + neighbor.getWeight();
                    minHeap.offer(new Node(neighbor.getPoint(), newDist));
                }
            }
        }
        return visited.size() == n ? totalTime : -1;
    }

}
