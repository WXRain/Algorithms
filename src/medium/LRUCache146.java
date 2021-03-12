package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache146 {
    class Node{
        int key;
        int value;
        Node(){}
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private List<Node> list;
    private int now;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        list = new LinkedList<Node>();
        now = 0;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node n = map.get(key);
        list.remove(n);
        list.add(0, n);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            list.remove(n);
            n.value = value;
            list.add(0, n);
            map.put(key, n);
            return;
        }
        Node node = new Node(key, value);
        if(now < capacity){
            list.add(0, node);
            map.put(key, node);
            now++;
        }else{
            Node n = list.get(list.size() - 1);
            map.remove(n.key);
            list.remove(n);
            map.put(key, node);
            list.add(0, node);
        }
    }
}
