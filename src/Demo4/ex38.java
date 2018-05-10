package Demo4;

import java.util.Arrays;

/**
 * @Author: Allen
 * @Description:    构建乘积数组
 * @Date: Created in 14:46 2018/2/6
 * @Modify By:
 */
public class ex38 {

    public static void multiply(int[] a, int[] b, int alength, int blength){
        if (a == null || b == null)
            return;
        if (alength == blength && blength > 0){
            b[0] = 1;
            // 自上而下顺序计算b数组值的一部分
            for (int i = 1; i < alength; ++i) {
                b[i] = b[i-1] * a[i-1];
            }
            int temp = 1;
            // 自下而上顺序计算b数组的值
            for (int i = blength-2; i >= 0; --i) {
                temp *= a[i+1];
                b[i] *= temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = new int[a.length];
        multiply(a,b,a.length,b.length);
        Arrays.stream(b).forEach(System.out::println);
    }
}
