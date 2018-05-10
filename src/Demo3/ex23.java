package Demo3;

/**
 * @Author: Allen
 * @Description: 从1到n整数中1出现的次数
 * @Date: Created in 13:57 2018/1/29
 * @Modify By:
 */
public class ex23 {

    public int count1(int n) {
        if (n <= 0)
            return 0;

        int count = 0;      // 统计 1 的总次数
        int weight = 0;     // 统计 10 的余数
        int base = 1;       // 基数
        int round = n;      // 需要统计的数
        while (round > 0) {
            weight = round % 10;     //  获得余数
            round /= 10;            //  获得整除数
            count += round * base;    //  每过 0-9 一回就出现 1 次数为 round*base
            if (weight == 1) {       //  余数等于一时就需要特殊处理
                count += (n % base) + 1;  //   11%1  商11  余 0
            } else if (weight > 1) {    // 就是如  531  十位上3 大于1，
                // 所以会出现十几的10个数，所以就得直接加上  base
                count += base;
            }
            base *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        ex23 e = new ex23();
        System.out.println(e.count1(12));
    }
}
