import java.util.HashMap;

public class LRUCache
{
    class Node
    {
        int key;
        int val;
        Node next;
        Node prev;


        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    private final HashMap<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;

    private int size;
    private int currentSize = 0;


    public LRUCache(int capacity)
    {
        size = capacity;
    }


    public int get(int key)
    {
        if (map.containsKey(key))
        {
            Node node = map.get(key);
            moveNodeToTail(node);
            return node.val;
        }
        else
        {
            return -1;
        }
    }


    private void moveNodeToTail(Node node)
    {
        if (node == tail)
        {
            return;
        }
        if (node == head && node.next != null)
        {
            head = node.next;
        }
        if (node.prev != null)
        {
            node.prev.next = node.next;
        }
        if (node.next != null)
        {
            node.next.prev = node.prev;
        }
        tail.next = node;
        node.next = null;
        node.prev = tail;
        tail = node;
    }


    public void put(int key, int value)
    {
        if (map.containsKey(key))
        {
            Node node = map.get(key);
            node.val = value;
            moveNodeToTail(node);
            map.put(key, node);
            return;
        }
        else if (size <= currentSize)
        {
            map.remove(head.key);
            head = head.next;
        }

        Node node = new Node(key, value);
        if (head == null)
        {
            head = node;
        }
        if (tail == null)
        {
            tail = node;
        }
        else
        {
            tail.next = node;
            node.next = null;
            node.prev = tail;
            tail = node;
        }
        map.put(key, node);
        currentSize++;
    }


    public static void main(String[] args)
    {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4

        //        LRUCache cache = new LRUCache(2);
        //        //cache.put(1, 1);
        //        System.out.println(cache.get(2));
        //        cache.put(2, 6);
        //        System.out.println(cache.get(1)); // returns -1 (not found)
        //        cache.put(1, 5);
        //        cache.put(1, 2);
        //        System.out.println(cache.get(1)); // returns -1 (not found)
        //        System.out.println(cache.get(2)); // returns 3

        //        LRUCache cache = new LRUCache(3);
        //        cache.put(1, 1);
        //        cache.put(2, 2);
        //        cache.put(3, 3);
        //        cache.put(4, 4);
        //        System.out.println(cache.get(4));
        //        System.out.println(cache.get(3));
        //        System.out.println(cache.get(2));
        //        System.out.println(cache.get(1));
        //        cache.put(5, 5);
        //        System.out.println(cache.get(1)); // returns -1 (not found)
        //        System.out.println(cache.get(2)); // returns -1 (not found)
        //        System.out.println(cache.get(3)); // returns -1 (not found)
        //        System.out.println(cache.get(4)); // returns -1 (not found)
        //        System.out.println(cache.get(5)); // returns -1 (not found)

        //        LRUCache cache = new LRUCache(2);
        //        cache.put(2, 1);
        //        cache.put(2, 2);
        //        System.out.println(cache.get(2));
        //        cache.put(1, 1);
        //        cache.put(4, 1);
        //        System.out.println(cache.get(2));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
