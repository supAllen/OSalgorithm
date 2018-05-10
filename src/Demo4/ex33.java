package Demo4;

/**
 * @Author: Allen
 * @Description:    扑克牌中的顺子
 * @Date: Created in 15:59 2018/2/4
 * @Modify By:
 */
public class ex33 {
    public boolean isContinues(int[] number, int length){
        boolean flag = false;
        if (number == null || length <= 0)
            return flag;
        // 利用计数排序
        int[] p = new int[14];
        int max = number[0],min = number[0];
        for (int i = 0; i < length; i++) {
            ++p[number[i]];
            if (number[i] < min)
                min = number[i];
            if (number[i] > max)
                max = number[i];
        }
        for (int i = 0; i < 14; i++) {
            System.out.print(p[i] + "\t");
        }
        System.out.println();
        int diff = max-min;
        System.out.println(diff);
        boolean like = true;
        for (int i = 0; i < 14; i++) {
            if (p[i] >= 2){
                like = false;
                break;
            }
        }
        if (diff <= 4)
            flag = true;
        return flag && like;
    }

    /**
     * 方法一
     * 1+2+...+n  不使用各种 。。。
     * @param n
     * @return
     */
    public int sum_Solution(int n){
        int result = n;
        // && 代替 if
        // 递归代替循环
        boolean value = (n > 0) && ((result = result + sum_Solution(n-1)) == 0);
        return result;
    }

    public static void main(String[] args) {
        ex33 e = new ex33();
        int[] a = {1,2,3,4,4};  // 大小王出现的话，就默认转换为可以转换成顺子的样子
        System.out.println(e.isContinues(a,a.length));
        //System.out.println(e.sum_Solution(100));
    }
}
