package Demo1;

/**
 * 旋转数组中寻找最小值
 */
public class ex5 {
    public static int getmin(int[] a){
        if (a == null)  throw new NullPointerException("数组为空");
        int i = 0, j = a.length-1;
        while (i+1 != j){
            int index = (i + j)/2;
            // 大于等于第一个指向的元素
            if (a[index] >= a[i]){
                i = index;
            }
            // 小于等于第二个指针指向的元素
            else if (a[index] <= a[j]){
                j = index;
            }
            // 如果出现  {1,0,1,1,1}  或者  {1,1,1,0,1} 就转顺序查询
            if (a[index] == a[i] && a[index] == a[j]){
                return minnumber(a);
            }
        }
        return a[j];
    }

    // 顺序查找
    public static int minnumber(int[] a){
        if (a == null ) throw new NullPointerException("数组为空");
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min){
                min = a[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,0,1};
        System.out.println(getmin(a));
    }
}
