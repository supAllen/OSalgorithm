package OSInterview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: Allen
 * @Description:    LRUCache 实现
 * @Date: Created in 18:59 2018/5/10
 * @Modify By:
 */
public class LRUCache {
    private int capacity;
    private Map<Integer,Integer> map;
    private LinkedList<Integer> numList;
    
    /*
    * @param capacity: An integer
    */
    public LRUCache(int capacity) {
        assert capacity > 0;
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        numList = new LinkedList<>();
    }
    /*
     * @param key: An integer
     * @return: An integer
     */
    int get(Integer key) {
        assert key >= 0;
        Integer value = map.get(key);
        if (value == null)
            return -1;
        numList.remove(key);
        numList.addLast(key);
        return value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    void set(int key, int value) {
        assert key >= 0;
        assert value >= 0;
        if (numList.size() >= this.capacity){   // 缓存区满了
            Integer firstkey = numList.removeFirst();
            Integer firstvalue = map.get(firstkey);
            map.remove(firstkey,firstvalue);
        }
        // 添加新元素
        numList.addLast(key);
        map.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.set(2,1);
        l.set(1,1);
        System.out.println(l.get(2));
        l.set(4,1);
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.toString());
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map +
                '}';
    }
}
