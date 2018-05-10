package Demo2;

import java.lang.reflect.Method;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * 考虑同类问题的通用型
 */
public class ex11 {

    /**
     * @param data  数组
     * @param length 数组长度
     */
    public void ReorderOddEven(int[] data, int length, String funName) throws Exception{
        Method method = methodDemo.class.getMethod(funName, int.class);
        System.out.println(method);
        if (data == null || length <= 0)    return;
        int start = 0;
        int end = length-1;
        while (start <= end){
            // 如果不是偶数就一直向后找   (data[start] & 0x1) != 0
            System.out.println((Boolean) method.invoke(methodDemo.class.newInstance(),data[start]));
            while (start <= end && !((Boolean) method.invoke(methodDemo.class.newInstance(),data[start]))){
                System.out.println("jinlaii");
                start++;
            }
            // 如果不是奇数就一直向前找
            System.out.println((Boolean) method.invoke(methodDemo.class.newInstance(),end));
            while (start <= end && ((Boolean) method.invoke(methodDemo.class.newInstance(),data[end]))){
                end--;
            }
            int temp = 0;
            if (start < end){
                temp = data[start];
                data[start] = data[end];
                data[end] = temp;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int[] array = {1,2,3,4,5};
        new ex11().ReorderOddEven(array,5,"isEven");
        for (int a :
                array) {
            System.out.println(a);
        }
    }
}
