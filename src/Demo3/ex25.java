package Demo3;

/**
 * @Author: Allen
 * @Description:    丑数
 * @Date: Created in 13:10 2018/1/30
 * @Modify By:
 */
public class ex25 {

    public int GetUglyNumber(int index){
        if (index <= 0)
            return 0;
        int[] array = new int[index];   // 空间换时间
        array[0] = 1;
        int t2 = 0,t3 = 0,t5 = 0;       // 向后推进所需要的三个数
        for (int i = 1; i < index; i++) {
            array[i] = Math.min(array[t2]*2,Math.min(array[t3]*3,array[t5]*5));     // 三个数中取最小值
            if (array[i] == array[t2]*2)
                ++t2;
            if (array[i] == array[t3]*3)
                ++t3;
            if (array[i] == array[t5]*5)
                ++t5;
        }
        return array[index-1];
    }

    public static void main(String[] args) {
        ex25 e = new ex25();
        System.out.println(e.GetUglyNumber(1500));
        System.out.println(Integer.MAX_VALUE);
        System.out.println((int)Math.pow(2,31));
    }
}
