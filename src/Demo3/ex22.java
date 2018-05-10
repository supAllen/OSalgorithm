package Demo3;

/**
 *  连续子数组的最大和
 */
public class ex22 {

    public int FindGreatesSumOfSubArray(int[] pdata, int length){
        if (pdata == null && length <=0)
            new NullPointerException("输入数组为空或者输入参数有误");

        int sumAll = pdata[0];  // 存放累加和
        int maxSumAll = pdata[0];   // 存放最大和
        for (int i = 1; i < length; i++) {
            sumAll += pdata[i];  // 无脑累加
            if (sumAll <= 0)     // 当累加合小于0时
                sumAll = 0;
            maxSumAll = maxSumAll > sumAll ? maxSumAll : sumAll;
        }
        return maxSumAll;
    }

    public static void main(String[] args) {
        ex22 e = new ex22();
        int[] a= {1,-2,3,10,-4,7,2,-5};
        int[] b = null;
        System.out.println(e.FindGreatesSumOfSubArray(b,b.length));
    }

}
