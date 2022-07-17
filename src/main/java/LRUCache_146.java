import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {
    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode() {}
        public DLinkNode(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }
    private int capacity;
    private int size;
    public Map<Integer, DLinkNode> cache = new HashMap<>();
    private DLinkNode head, tail;
    public LRUCache_146(int capacity) {
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        DLinkNode res = cache.get(key);
        if (res == null) return -1;
        moveToHead(res);
        return res.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);

        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            size++;
            cache.put(key,newNode);
            addToHead(newNode);
            if (size > capacity) {
               DLinkNode tail = removeTail();
               cache.remove(tail.key);
               size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }
    private  void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }

    private DLinkNode removeTail(){
        DLinkNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
