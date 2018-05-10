package Demo6;

/**
 * @Author: Allen
 * @Description:    在某种钱数下，有几种面值的情况下次数
 * @Date: Created in 10:11 2018/3/4
 * @Modify By:
 */
public class dtgh {
    public static int coin1(int[] array,int aim){
        if (array == null || array.length == 0 || aim < 0){
            return 0;
        }
        return process1(array,0,aim);
    }

    public static int process1(int[] arr,int index,int aim){
        int res=0;
        if (index == arr.length)
            res = aim == 0 ? 1 : 0;     // 面值减到零就算一次
        else {
            for (int i = 0; arr[index]*i <= aim; ++i) {
                res+=process1(arr,index+1,aim-arr[index]*i);    // aim-arr[index]*i 减掉几次那种面值的
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {5,10,25,1};
        int aim = 2;
        System.out.println(coin1(a,aim));
    }
}
