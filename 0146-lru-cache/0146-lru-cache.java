class LRUCache {
    class Node {
        Node prev=null;
        Node next=null;

        int key;
        int val;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }


    Map<Integer, Node> map;
    int capacity;
    Node start = null;
    Node end = null;
    int size = 0;

    public void addNode(Node prevNode, Node newNode){
        newNode.next = prevNode.next;
        newNode.prev = prevNode;

        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    public void delNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
        
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;

        start = new Node(-1,-1);
        end = new Node(-1,-1);

        start.next = end;
        end.prev = start;

    }


    public int get(int key) {
        if (map.get(key) == null)
            return -1;
        Node node = map.get(key);
        delNode(node);
        addNode(start, node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.get(key) == null){
            map.put(key, new Node(key, value));
            addNode(start, map.get(key));
            if (size == capacity){
                map.remove(end.prev.key);
                delNode(end.prev);
            }
            else
                size++;
        }
        else {
            Node node = map.get(key);
            node.val = value;
            delNode(node);
            addNode(start, node);
        }
    }
}