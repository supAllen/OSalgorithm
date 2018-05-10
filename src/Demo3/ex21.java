package Demo3;

import Demo2.ex19;

import java.util.*;

/**
 *  最小的K个数
 */
public class ex21 {

    // 方法一 ：
    // 此方法不适合处理海量数据
    // 此方法会修改数组元素的顺序
    /**
     * @param array
     * @param length
     * @param output
     * @param k
     */
    public void GetLeastNumbers(int[] array, int length ,int[] output, int k){
        if (array == null && length <=0 && k <=0){
            new Exception("输入参数有误");
        }
        int start = 0;
        int end = length -1;
        ex19 e = new ex19();
        int index = e.Partition(array,length,start,end);
        while (index != k-1){
            if (index > k-1){
                end = index-1;
                index = e.Partition(array,length,start,end);
            }
            else {
                start = index+1;
                index = e.Partition(array,length,start,end);
            }
        }
        for (int i = 0; i < k; i++) {
            output[i] = array[i];
            System.out.println(output[i]);
        }
    }

    // 方法2
    // 此方法适合处理海量数据
    // 不该变数组
    /**
     *   TreeSet  是一个底层是红黑树（自平衡的二叉树）实现的
     *   内部对元素操作都是O(logn)的时间复杂度，并且内部元素是已经排序好的元素
     * @param data
     * @param set
     * @param k
     */
    public void GetLeastNumbers2(final int[] data, TreeSet<Integer> set, int k){
        if (data == null)
            new NullPointerException("数组为空");
        for (int i = 0; i < data.length; i++) {
            // 容器 还没满就继续装
            if (set.size() < k){
                set.add(data[i]);
            }
            // 容器满了后
            else {
                // 1、 找出容器中的最大值
                // 2、 判断现在的值与容器中的最大值比较 如果新进来的值比较小 删除这个最大值
                // 3、 并且将新进来的值插入，否则就丢弃这个新进来的值
                if (set.last() > data[i]){
                    set.remove(set.last());
                    set.add(data[i]);
                }
            }
        }
        //  forEach 在最上层的父类中，所有集合类都有
        set.forEach(System.out::print);
    }

    public static void main(String[] args) {
        /*int[] a = {4,5,1,6,2,7,3,8};
        int k = 4;
        int[] output = new int[k];
        ex21 e = new ex21();
        e.GetLeastNumbers(a,a.length,output,k);
        Arrays.stream(output).forEach(System.out::print);

        System.out.println();
        TreeSet<Integer> treeSet = new TreeSet<>();
        e.GetLeastNumbers2(a,treeSet,k);*/
        Map<String,String> map = new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.entrySet().forEach(System.out::print);
        for (Map.Entry<String, String> entry :
                map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
