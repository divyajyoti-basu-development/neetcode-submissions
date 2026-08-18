/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> visitedMap = new HashMap<>();        
        return recursiveCopyList(visitedMap, head);
    }

    private Node recursiveCopyList(Map<Node, Node> visitedMap, Node current) {
        if(current == null) {
            return null;
        }
        if(visitedMap.containsKey(current)) {
            return visitedMap.get(current);
        }
        Node copyNode = new Node(current.val);
        visitedMap.put(current, copyNode);
        copyNode.next = recursiveCopyList(visitedMap, current.next);
        copyNode.random = recursiveCopyList(visitedMap, current.random);
        return copyNode;
    }
}
