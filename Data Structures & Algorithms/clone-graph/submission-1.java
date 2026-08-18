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

    private Node dfsClone(Node node, Map<Node, Node> cloneMap) {
        if(node == null) {
            return null;
        }
        if(cloneMap.containsKey(node)) {
            return cloneMap.get(node);
        }
        Node clone = new Node(node.val);
        cloneMap.put(node, clone);
        for(Node neighbor : node.neighbors) {
            clone.neighbors.add(dfsClone(neighbor, cloneMap));
        }
        return clone;
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> cloneMap = new HashMap<>();
        return dfsClone(node, cloneMap);
    }
    
}