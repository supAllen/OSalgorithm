package Demo4;

/**
 * @Author: Allen
 * @Description: 数组中重复的数字
 * @Date: Created in 13:21 2018/2/6
 * @Modify By:
 * /*number[i] = number[i] ^ number[number[i]];        //  因为修改了数组中的值，所以是有问题的
 * number[number[i]] = number[i] ^ number[number[i]];
 * number[i] = number[i] ^ number[number[i]];
 */
public class ex37 {
    public static boolean duplicate(int[] number, int n) {
        if (number == null || n < 1)
            return false;
        // 判断数组中有没有越过数组界限的数，数组不符合规范
        for (int i = 0; i < n; i++) {
            if (number[i] >= n || number[i] < 0) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            while (number[i] != i) {    // 元素不等于第一个位置的下标
                if (number[i] == number[number[i]]) {
                    return true;
                }
                int temp = number[i];
                number[i] = number[temp];
                number[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate(a, a.length));
    }
}
