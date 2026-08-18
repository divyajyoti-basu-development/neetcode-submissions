class LRUCache {

    private Map<Integer, ListNode> cache;
    private ListNode head;
    private ListNode tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.head = new ListNode(0, 0, null, null);
        this.tail = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            ListNode data = cache.get(key);
            if(tail == data) {
                return data.value;
            }
            data.previous.next = data.next;
            data.next.previous = data.previous;
            tail.next = data;
            data.previous = tail;
            data.next = null;
            tail = data;
            return data.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        System.out.println("Put Key: " + key + " Value: " + value);
        if(cache.containsKey(key)) {
            ListNode data = cache.get(key);
            data.value = value;
            if(tail == data) {                
                return;
            } else {
                data.previous.next = data.next;
                data.next.previous = data.previous;
                tail.next = data;
                data.previous = tail;
                data.next = null;
                tail = data;
                return;
            }
        } else {
            System.out.println("Key doesnt exist");
            ListNode newData = new ListNode(key, value, null, null);
            tail.next = newData;
            newData.previous = tail;
            tail = newData;
            if(cache.size() == capacity) {
                System.out.println("Cache full at capacity: " + cache.size());
                ListNode data = head.next;                
                head.next = data.next;
                data.next.previous = head;
                cache.remove(data.key);
            } 
            cache.put(key, newData);
        }
    }

    private class ListNode {
        int key;        
        int value;
        ListNode next;
        ListNode previous;

        ListNode(int key, int value, ListNode next, ListNode previous) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
