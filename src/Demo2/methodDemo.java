package Demo2;

/**
 * 例11 中的模板方法
 */
public class methodDemo {
   /* public static void main(String[] args) throws Exception{
        int[] array = {1,2,3,4,5};
        Method method = methodDemo.class.getMethod("isEven", int.class);
        System.out.println((Boolean) method.invoke(methodDemo.class.newInstance(),4));
    }

    public void fun(){
        System.out.println("...");
    }*/

   // 模板方法1
    public boolean isEven(int n){
        if (n <=0 ){
            new Exception("数据格式错误");
        }
        // 此处判断的是是否为偶数
        return (n & 0x1) == 0;
    }
}
