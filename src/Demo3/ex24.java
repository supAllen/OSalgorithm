package Demo3;

import java.util.*;

/**
 * @Author: Allen
 * @Description:  数组所能组成的最小的数
 * @Date: Created in 16:35 2018/1/29
 * @Modify By:
 */
public class ex24 {

    public String PrintMinNumber(int[] array){
        if (array == null)
            new NullPointerException("数组为空");

        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // 将所有数放进数组中
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        // 对数组按一定规则进行排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });
        // 将排序好 的数组链接起来
        for (int i :
                list) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ex24 e = new ex24();
        int[] a = {3,32,321};
        System.out.println(e.PrintMinNumber(a));
    }
}
