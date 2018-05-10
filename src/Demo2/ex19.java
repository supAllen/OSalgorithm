package Demo2;

import java.util.Random;

/**
 * 快排   随机数化
 */
public class ex19 {

    /**
     * 分治算法的体现
     *
     * 按条件分割数组利器！！！
     *
     * @param data
     * @param length
     * @param start
     * @param end
     * @return
     */
    public int Partition(int[] data, int length, int start, int end) {
        if (data == null && length <= 0 && start < 0 && end >= length) {
            new NullPointerException("数组异常");
        }
        Random r = new Random();
        //  错误1   随机数范围没有控制好
        int index = r.nextInt(end - start) + start;     // 产生  start -》 end之间的数
        //  不能使用函数，不能使用加减那个（会出现零）
        int temp = 0;
        if (data[index] != data[end]) {
            temp = data[index];
            data[index] = data[end];
            data[end] = temp;
        }
        int small = start - 1;
        for (index = start; index < end; ++index) {
            if (data[index] < data[end]) {
                ++small;
                if (small != index && data[index] != data[small]) {
                    temp = data[index];
                    data[index] = data[small];
                    data[small] = temp;
                }
            }
        }
        ++small;
        if (data[small] != data[end]) {
            temp = data[small];
            data[small] = data[end];
            data[end] = temp;
        }
        return small;
    }

    /**
     * 快排主方法
     * @param data
     * @param length
     * @param start
     * @param end
     */
    public void QuickSort(int[] data, int length, int start, int end) {
        if (start == end)
            return;
        int index = Partition(data, length, start, end);
        System.out.println("index: " + index);
        if (index > start)
            QuickSort(data, length, start, index - 1);
        if (index < end)
            QuickSort(data, length, index + 1, end);
    }

    public static void main(String[] args) {
       /* Random r = new Random();
        int num = r.nextInt(10);
        System.out.println(num);*/

        ex19 e = new ex19();
        int[] a = {7, 8, 4, 3, 6, 5, 11, 13, 9, 15};
        e.QuickSort(a, 10, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
