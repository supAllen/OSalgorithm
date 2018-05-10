package Demo3;

import java.util.Arrays;

/**
 * @Author: Allen
 * @Description:    数组中只出现一次的数字
 * @Date: Created in 15:30 2018/1/30
 * @Modify By:
 */
public class ex27 {

    /**
     * 得到数组的分割数   异或法
     * @param array
     * @return
     */
    public int getDivideNum(int[] array){
        if (array == null)
            new NullPointerException("数组异常");

        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];         // 两数相同则结果为零
        }
        return result;
    }

    /**
     * 根据分割数分割数组，然后对新数组再进行异或
     * @param array
     * @param count
     * @return
     */
    public int[] getNum(int[] array, int count){
        if (array == null)
            new NullPointerException("数组异常");
        int divideNum = getDivideNum(array);
        int[] a1 = new int[array.length];
        int[] a2 = new int[array.length];
        int n1 = -1,n2 = -1;
        for (int j = 0; j < array.length; j++) {
            if ((array[j] & divideNum) == divideNum)    // 对应位相同才会有结果，否则是0
                a1[++n1] = array[j];
            else if ((array[j] & divideNum ) != divideNum)
                a2[++n2] = array[j];
        }
        int[] result = {a1[0],a2[0]};
        for (int j = 1; j <=n1 ; j++) {
            result[0] ^= a1[j];
        }
        for (int j = 1; j <=n2 ; j++) {
            result[1] ^= a2[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2,4,3,6,3,2,5,5};
        int[] result = new int[2];
        ex27 e = new ex27();
        result = e.getNum(a,2);
        Arrays.stream(result).forEach(System.out::println);
    }
}
