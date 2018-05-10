package Demo1;

/**
 * 斐波那契数求第N个数
 */
public class ex6 {
    public static int getNum(int n){
        int[] a = new int[2];
        a[0] = 0;
        a[1] = 1;
        if (n < 2)  return a[n];
        int fib = 0;
        int fibone = 1;
        int fibtwo = 0;
        for (int i = 2; i <= n; i++) {
            fib = fibone + fibtwo;
            fibone = fib;
            fibtwo = fibone;
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(getNum(3));
    }
}
