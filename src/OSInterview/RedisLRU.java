package OSInterview;

import java.util.LinkedList;

/**
 * @Author: Allen
 * @Description:    redis 实现 LRU的近似算法
 * @Date: Created in 21:08 2018/5/10
 * @Modify By:
 */
public class RedisLRU {
    private int capacity;
    private LinkedList<dataNode<Integer>> numList;

    /*
    * @param capacity: An integer
    */
    public RedisLRU(int capacity) {
        assert capacity > 0;
        this.capacity = capacity;
        numList = new LinkedList<>();
    }
    /*
     * @param key: An integer
     * @return: An integer
     */
    int get(dataNode<Integer> value) {
        assert value.getData() >= 0;
        if (!numList.contains(value))
            return -1;
        value.setModifyTime(System.nanoTime());
        return 0;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    void set(dataNode<Integer> value) {
        assert value.getData() >= 0;
        if (this.numList.contains(value)){
            value.setModifyTime(System.nanoTime());
            return;
        }
        if (this.numList.size() >= this.capacity){
            // 寻找出距离现在时间最长
            dataNode<Integer> data = null;
            long min = 0;
            for (dataNode<Integer> num: numList) {
                long diffTime = System.nanoTime()-num.getModifyTime();
                if (diffTime > min){
                    min = diffTime;
                    data = num;
                }
            }
            numList.remove(data);
        }
        numList.addLast(value);
    }

    public static void main(String[] args) {
        RedisLRU lru = new RedisLRU(3);
        lru.set(new dataNode<>(7,System.nanoTime()));
        lru.set(new dataNode<>(0,System.nanoTime()));
        lru.set(new dataNode<>(1,System.nanoTime()));
        lru.set(new dataNode<>(2,System.nanoTime()));
        lru.set(new dataNode<>(0,System.nanoTime()));
        lru.set(new dataNode<>(3,System.nanoTime()));
        lru.set(new dataNode<>(0,System.nanoTime()));
        for (dataNode<Integer> data :lru.numList) {
            System.out.println(data.getData());
        }
    }

    @Override
    public String toString() {
        return "RedisLRU{" +
                "numList=" + numList +
                '}';
    }
}

class dataNode<T>{
    private T data;
    private long modifyTime;

    public dataNode(T data, long modifyTime) {
        this.data = data;
        this.modifyTime = modifyTime;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }
}
