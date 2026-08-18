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

    Map<Node, Node> visited = new HashMap<>(); 

    private Node dfs(Node head) {
        if(head == null) {
            return null;
        }
        if(visited.containsKey(head)) {
            return visited.get(head);
        }
        Node newNode = new Node(head.val);
        visited.put(head, newNode);
        newNode.next = dfs(head.next);
        newNode.random = dfs(head.random); 
        return newNode;
    }

    public Node copyRandomList(Node head) {
        return dfs(head);
    }
}