package Demo3;

/**
 * @Author: Allen
 * @Description: 和为s的两个数VS为S的连续正数序列
 * @Date: Created in 9:26 2018/2/2
 * @Modify By:
 */
public class ex30 {

    /**
     * 和为S的两个数
     *
     * @param array
     * @param length
     * @param k
     */
    public void FindNumberWithSum(int[] array, int length, int k) {
        if (array == null || length <= 0) {
            new NullPointerException("数组异常");
        }

        int start = 0;
        int end = length - 1;
        int sum = 0;
        boolean flag = false;
        while (start <= end) {
            sum = array[start] + array[end];
            if (sum == k) {
                flag = true;
                System.out.println("和为S的两个数为：" + array[start] + "\t" + array[end]);
                break;
            } else if (sum < k) {
                ++start;
            } else
                --end;
        }
        if (flag == false)
            System.out.println("不存在那两个数");
    }

    /**
     * 和为S的连续正整数序列
     *
     * @param num
     */
    public void FindContinuousSequence(int num) {
        boolean flag = false;
        if (num < 3)
            return;
        int small = 1;
        int big = 2;
        int sum = 0;
        do {
            for (int i = small; i <= big; ++i) {
                sum += i;
            }
            if (sum == num) {
                flag = true;
                for (int i = small; i <= big; ++i) {
                    if (i == big) {
                        System.out.println(i);
                    } else
                        System.out.print(i + "+");
                }
                System.out.println();
                ++small;    //   当等于的时候还要看看后面还有没，所以要  ++small
            } else if (sum < num)
                ++big;
            else
                ++small;
            sum = 0;
        } while (small < (num + 1) / 2);
        if (flag == false)
            System.out.println("不存在和为S的连续正数序列");
    }

    public static void main(String[] args) {
        ex30 e = new ex30();
        int[] a = {1, 2, 4, 7, 11, 15};
        e.FindNumberWithSum(a, a.length, 120);
        e.FindContinuousSequence(3);
    }
}
