class LRUCache {
    public class Node{
        Node prev, next;
        int key, val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        Node(){}
    }
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int limit;
    int size = 0;
    HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        limit = capacity;
        size = 0;
    }
    public void del(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public int get(int key) {
        if(map.containsKey(key) == false) return -1;
        int val = map.get(key).val;
        del(map.get(key));
        insert(key, val);
        return val;
    }
    public void insert(int key, int val){
        Node nex = head.next;
        Node nn = new Node(key, val);
        nn.next = nex;
        nn.prev = head;
        head.next = nn;
        nex.prev = nn;
        map.put(key, nn);
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            del(map.get(key));
        }
        if(map.size() == limit) {
            del(tail.prev);
        }
        insert(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */