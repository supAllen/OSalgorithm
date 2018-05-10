package Demo4;

/**
 * @Author: Allen
 * @Description:    N个骰子的点数
 * @Date: Created in 9:33 2018/2/3
 * @Modify By:
 */
public class ex32 {

    private static int g_maxValue = 6;

    /**
     *
     * @param number  骰子个数
     */
    public void PrintProBability(int number){
        if (number < 1)
            return;
        int maxSum = number * g_maxValue;   // 所能要出来的最大值
        int[] pProBabilities = new int[maxSum+1];    // 建立对应的数组
        for (int i = number; i <= maxSum; ++i) {    // 初始化概率数组
            pProBabilities[number] = 0;
        }
        ProBability(number,pProBabilities); //  递归处

        double total = Math.pow((double)g_maxValue,number); // 概率的分母
        for (int i = number; i <= maxSum; i++) {
            System.out.println(i+": \t"+pProBabilities[i]/total);
        }
    }

    /**
     *
     * @param number    骰子个数
     * @param pProBabilities    可能产生的数的数组
     */
    public void ProBability(int number, int[] pProBabilities){
        for (int i = 1; i <= g_maxValue; ++i) {
            ProBability(number,i,pProBabilities);
        }
    }

    /**
     *
     * @param current   当前的骰子的个数
     * @param sum
     * @param pProBabilities    可能产生的数的数组
     */
    public void ProBability(int current, int sum,int[] pProBabilities){
        if (current == 1)   // 只有一个骰子
            ++pProBabilities[sum];  // 对应位数量加一
        else {  // 否则
             for (int i = 1; i <= g_maxValue; i++) {    // 每个骰子都存在6种情况
                 // current-1  骰子数目减少
                 // i+sum  记录点数和
                ProBability(current-1,i+sum,pProBabilities);
            }
        }
    }

    /**
     * 非递归做法
     * @param number
     */
    public void PrintProbability2(int number){
        if (number < 1)
            return;

        int[][] p = new int[2][g_maxValue*number+1];
        // 初始化
        for (int i = 0; i < g_maxValue*number+1; i++) {
            p[0][i] = 0;    // 和为N出现的次数
            p[1][i] = 0;    // 第一个数组对应的N-1、N-2、N-3、N-4、N-5、N-6之和
        }
        int flag = 0;
        for (int i = 1; i <=g_maxValue ; i++) {
            p[flag][i] = 1;
        }
        for (int num = 2; num <= number; ++num) {   // 筛子个数
            for (int i = 0; i < num; ++i) {
                p[1-flag][i] = 0;
            }
            for (int j = num; j <= g_maxValue*num; ++j) {   // 相应个数下的骰子对应的所有情况
                p[1-flag][j] = 0;
                for (int i = 1; i <=j && i <= g_maxValue; ++i) {
                    p[1-flag][j] += p[flag][j-i];
                }
                for (int i = 0; i < g_maxValue*number+1; i++) {
                    System.out.print(p[1][i]+"\t");
                }
                System.out.println();
                for (int i = 0; i < g_maxValue*number+1; i++) {
                    System.out.print(p[0][i]+"\t");
                }
                System.out.println();
            }
            flag = 1-flag;
        }

        for (int i = number; i <g_maxValue*number+1 ; ++i) {
            System.out.println(i + ": "+ p[flag][i]/Math.pow(g_maxValue,number));
        }
    }

    public static void main(String[] args) {
        ex32 e = new ex32();
        //e.PrintProBability(3);
        e.PrintProBability(3);
    }
}
