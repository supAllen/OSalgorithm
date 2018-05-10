package Demo4;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Allen
 * @Description: 约瑟夫环
 * @Date: Created in 10:24 2018/2/5
 * @Modify By:
 */
public class ex34 {

    /**
     * @param n 参与的数字个数
     * @param m 步长
     * @return
     */
    public static int LastRemaining(int n, int m) {
        if (n < 1 || m < 1)
            return Integer.MIN_VALUE;
        if (n == 1) return 0;   // 只有一个数时返回
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            list.add(i);
        }
        int count = m - 1;    // 控制步数
        int index = 0;      // 控制在链表中的位置
        do {
            if (index == list.size()) {
                index = 0;   // 相当于到了链表的头部
            }
            if (count == 0) {
                list.remove(list.get(index));
                count = m - 1; // 再次初始化步数
            } else {
                --count;    // 剩余步数
                ++index;
            }
        } while (list.size() > 1);
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining(4000, 997));
    }
}
