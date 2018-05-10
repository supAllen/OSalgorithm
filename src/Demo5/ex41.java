package Demo5;

import java.util.LinkedList;

/**
 * @Author: Allen
 * @Description:    滑动窗口的最大值
 * @Date: Created in 20:01 2018/2/10
 * @Modify By:
 */
public class ex41 {

    public static int[] maxInWondow(int[] array, int length, int k){
        if (array == null || length <=0 || k <1)
            return null;
        int[] result = new int[length+1-k];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; ++i) {
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if (!deque.isEmpty() && deque.peek() == i-k)
                deque.poll();
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while (!deque.isEmpty() && array[deque.peekLast()] < array[i])
                deque.pollLast();
            // 添加新元素
            deque.offer(i);
            // 队列头部就是该窗口内第一大的
            if ((i+1) >= k)
                result[i+1-k] = array[deque.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2,3,4,2,6,2,5,1};
        int[] res = maxInWondow(a,a.length,3);
        for (int n :
                res) {
            System.out.print(n+"\t");
        }
    }
}
