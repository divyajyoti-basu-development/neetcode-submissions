/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private Node recursiveCloneGraph(Node node, Map<Node, Node> visited) {
        if(node == null) {
            return null;
        }
        if(visited.containsKey(node)) {
            return visited.get(node);
        }
        Node copiedNode = new Node(node.val);
        visited.put(node, copiedNode);
        node.neighbors.forEach(neighbour -> {
            Node copiedNeighbour = recursiveCloneGraph(neighbour, visited);
            copiedNode.neighbors.add(copiedNeighbour);
    });
        return copiedNode;
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return recursiveCloneGraph(node, visited);
    }
}