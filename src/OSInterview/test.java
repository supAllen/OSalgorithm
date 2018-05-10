package OSInterview;

import java.util.Arrays;

/**
 * @Author: Allen
 * @Description:
 * @Date: Created in 16:47 2018/5/9
 * @Modify By:
 */
public class test {
    public static void main(String[] args) {
        int[] b = {1,2};
        t(b);
        System.out.println(Arrays.toString(b));
    }

    public static void t(int[] a){
        a[0] = 2;
    }
}
