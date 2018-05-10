package Demo5;

import java.util.AbstractQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @Author: Allen
 * @Description:
 * @Date: Created in 22:05 2018/2/9
 * @Modify By:
 */
public class PriorityQueueDemo<T> extends AbstractQueue<T> {

    private static int size = 0;   // 队列长度

    private static int length = 8; // 数组的初始长度

    private Object[] queue;  // 队列元素

    private Comparator<T> comparator;

    public PriorityQueueDemo() {
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(T t) {
        if (t == null) return false;    // 不允许插入空值
        int i = size;
        if (i > length)
            length = length << 1;     // 扩容操作
        size = i + 1;
        if (i == 0)  // 队列为空
            queue[i] = t;
        else
            siftUp(i, t);    // 调整
        return true;
    }

    /**
     * 调整函数
     * @param i     新添加的元素的位置
     * @param t     元素的值
     */
    private void siftUp(int i, T t) {
        while (i > 0) {
            int parent = (i - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(t, (T) e) >= 0)       // 由于Java是最小堆   这里意思是新添加的值大于父亲结点的值
                break;
            queue[i] = e;   // 先处理左右结点的值
            i = parent;     // 继续向上寻找不满足最小堆结点的值
        }
        queue[i] = t;   // 最后处理根结点
    }

    @Override
    public boolean add(T t) {
        return offer(t);
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }
}
