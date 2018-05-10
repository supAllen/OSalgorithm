package Demo4;

/**
 * @Author: Allen
 * @Description: 1+2+...+n  不使用各种 。。。
 * @Date: Created in 14:49 2018/2/5
 * @Modify By:
 */
public class ex35 {

    static int n;
    static int sum;
    public ex35() {
        ++n;
        sum+=n;
    }
    public static void reset(){
        n = 0;
        sum = 0;
    }

    public static int getsum(){
        return sum;
    }

    public static int getSum2(int n){
        reset();
        ex35[] e = new ex35[n]; // 构造对象数组并不能使对象的构造函数被调用
        System.out.println(e[0]);  // e[0] 此时是  null
        e[0] = new ex35();
        System.out.println(e[0]);
        return ex35.getsum();
    }

    /**
     * 方法一
     * @param n
     * @return
     */
    public static int getSum(int n){
        int result = n;
        boolean value = (n > 0) && ((result += getSum(n-1)) == 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getSum2(3)); // Java中行不通
        System.out.println(getSum(1));
    }
}
