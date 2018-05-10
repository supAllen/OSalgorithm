package Demo3;

/**
 * @Author: Allen
 * @Description: 数字在排序数组中出现的次数
 * @Date: Created in 9:27 2018/1/31
 * @Modify By:
 */
public class ex28 {

    public int GetFirstK(int[] array, int length, int k) {
        if (array == null || length <= 0)
            new NullPointerException("数组为空");
        int middle = length >> 1;
        int start = 0, end = length - 1;

        // 找出需要寻找的数的第一次下标的位置
        int startIndex = 0;
        while (start <= end) {
            if (array[middle] == k) {
                if (middle > 0 && array[middle - 1] != k || middle == 0) {
                    startIndex = middle;
                    break;
                } else
                    end = middle - 1;
            } else if (array[middle] > k)
                end = middle - 1;
            else
                start = middle + 1;
            middle = (start + end) >> 1;
        }

        // 找出需要寻找的数的最后一次出现的位置
        start = 0;
        end = length - 1;
        middle = (start + length) >> 1;
        int endIndex = 0;
        while (start <= end) {
            if (array[middle] == k) {
                if (middle < length-1 && array[middle + 1] != k || middle == length - 1) {
                    endIndex = middle;
                    break;
                } else
                    start = middle + 1;
            } else if (array[middle] > k)
                end = middle - 1;
            else
                start = middle + 1;
            middle = (start + end) >> 1;
        }
        return endIndex - startIndex + 1;
    }

    public static void main(String[] args) {
        ex28 e = new ex28();
        int[] a = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(e.GetFirstK(a, a.length, 5));
    }
}
