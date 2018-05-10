package Demo1;

/**
 *  二进制中1的个数
 */
public class ex7 {

    // 方法1
    public static int getcount(int n){
        int flag = 1;
        int count = 0;
        while (flag != 0){
            if ((flag & n) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // 方法2
    public static int getcount2(int n){
        int count = 0;
        while (n != 0){      // 如果是负数 还可以处理
            count++;     // 大于零的数最少有一个1
            n = (n-1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getcount2(-1));
    }
}
