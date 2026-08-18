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

    private Map<Node, Node> copyMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        if(!copyMap.containsKey(head)) {
            copyMap.put(head, new Node(head.val));
            copyMap.get(head).next = copyRandomList(head.next);
            copyMap.get(head).random = copyRandomList(head.random);
        } 
        return copyMap.get(head);
    }
}
