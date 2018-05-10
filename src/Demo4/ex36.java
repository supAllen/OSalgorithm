package Demo4;

/**
 * @Author: Allen
 * @Description:    不用加减乘除做加法
 * @Date: Created in 15:36 2018/2/5
 * @Modify By:
 */
public class ex36 {
    public static int add(int a, int b){
        do {
            //  异或运算的性质  0+0 = 0   1+1=0  1+0=1 0+1= 1
            //  所以sum计算的是不进位的情况   这里的不进位是二进制的不进位
            int sum = a ^ b;
            //  carry  计算的是二进制的进位
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while (b!=0);  // 当进位等于零结束循环
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}
