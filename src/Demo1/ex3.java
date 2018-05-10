package Demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 桶排序
 */
public class ex3 {
    public static void  bucketSort(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // 先获得边界值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        // 获得桶的个数
        int bucketNum = (max - min) / arr.length+1;

        // 创建桶 ，并初始化
        ArrayList<ArrayList<Integer>> bucketarr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketarr.add(new ArrayList<>());
        }

        // 装桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i]-min)/arr.length;
            bucketarr.get(num).add(arr[i]);
        }

        // 桶内排序
        for (int i = 0; i < bucketarr.size(); i++) {
            Collections.sort(bucketarr.get(i));
        }

        // 将桶内的数据装回数组
        int index =0;
        for (ArrayList<Integer> list :
                bucketarr) {
            for (Integer i :
                    list) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,3,5,34,26,14,25,33,234,354};
        bucketSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
