package Demo1;

/**
 * 数值的整数次方
 */
public class ex8 {
    public double getResult(double base, int exponent){
        // 处理了底数为零的情况
        if (equal(base,0.0) )   return 0;
        // 处理指数为0的情况
        if (exponent == 0) return 1;
        // 处理了指数为1 的情况
        if (exponent == 1) return base;
        // 处理指数为负数的情况
        double result = base;
        if(exponent < 0){
            result =  gettemp(base,exponent);
            return 1/result;
        }
        // 正常情况
        result =  gettemp(base,exponent);
        return result;
    }

    // double 数值不能直接比较，因为是他在计算机中存储的是近似值，有误差
    public boolean equal(double num1, double num2){
        if ((num1 - num2) > -0.0000001 && (num1 - num2) < 0.0000001){
            return true;
        }else return false;
    }

    // 减少乘方次数的函数
    public double gettemp(double base, int exponent){
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double result = gettemp(base,exponent >> 1);
        result *= result;  // 偶数时就直接乘
        if ((exponent & 0x1) == 1){     // 如果是奇数，最后一次乘一个基数
            result *= base;
        }
        return result;
    }

    public static void main(String[]  args) {
        System.out.println(new ex8().getResult(2,6));
    }
}
