/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * 
 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
 
 Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.
 
 NOTE: If you are using any global variables, make sure to clear them in the constructor.
 Example :
 
 Input : 
 capacity = 2
 set(1, 10)
 set(5, 12)
 get(5)        returns 12
 get(1)        returns 10
 get(10)       returns -1
 set(6, 14)    this pushes out key = 5 as LRU is full. 
 get(5)        returns -1 
 http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 */
import java.util.*;
public class LRU{
//    private int capacity;
//    private TreeMap<Integer, Integer> map;
//    public LRU(int capacity) {
//        this.capacity = capacity;
//        this.map = map = new TreeMap<Integer, Integer>();
//    }
//    
//    public int get(int key) {
//        if(map.containsKey(key))
//            return map.get(key);
//        return -1;
//    }
//    
//    public void set(int key, int value) {
//        if(!map.containsKey(key)){
//            if(map.size() < capacity)
//                map.put(key, value);
//            else{
//                System.out.println("removing : " + map.lastKey());
//                map.remove(map.lastKey());
//            }
//                
//        }
//        
//    }
    
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = null;
    private Node end = null;
    public LRU(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }
        else{
            Node created = new Node(key, value);
            if(map.size() >= capacity){
                System.out.println("Removing : ");
                map.remove(end.key);
                remove(end);
                setHead(created);
            }
            else{
                setHead(created);
            }
            map.put(key, created);
        }
        
    }
    
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
        if(head != null)
            head.pre = n;
        head = n;
        if(end == null)
            end = head;
    }
    
    public void remove(Node n){
        if(n.pre != null)
            n.pre.next = n.next;
        else
            head = n.next;
        
        if(n.next != null)
            n.next.pre = n.pre;
        else
            end = n.pre;
    }
    public static void main(String[] args){
        System.out.println("Main function");
        LRU l = new LRU(5);
        
        l.set(1, 10);
        l.set(5, 12);
        System.out.println(l.get(5));
        System.out.println(l.get(1));
        l.set(6, 14);
        
        l.set(7, 15);
        l.set(8, 16);
        l.set(9, 17);
        
        
        System.out.println(l.get(5));
    }
}