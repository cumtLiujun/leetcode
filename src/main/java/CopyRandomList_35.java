import java.util.HashMap;

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
class CopyRandomList {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
//        创建新节点
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
//      根据key 构建 value的next 和 random 关系；
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur= cur.next;
        }
        return map.get(head);
    }
}