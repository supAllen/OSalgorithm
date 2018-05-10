package Demo2;

/**
 *  数组中出现次数超过一半的数字
 */
public class ex20 {

    //    方法一：
    /**
     * 找出数组中出现次数超过一半的数
     * @param array
     * @param length
     * @return
     */
    public int MOreThanHalfNum(int[] array , int length){
        if (length <= 0) new NullPointerException("数组为空");
        int number = array[0];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (array[i] != number){
                --count;
                if (count == 0){
                    number = array[i];
                    count = 1;  // 此处要置一
                }
            }
            else {
                ++count;
            }
        }
        return number;
    }

    /**
     * 检查数组是否符合出现次数最多的元素次数超过数组元素个数的一半
     * @param array
     * @param length
     * @param num
     * @return
     */
    public boolean CheckMoreThanHalf(int[] array, int length, int num){
        if (length <= 0){
            new NullPointerException("数组为空");
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == num){
                ++count;
            }
        }
        if (count * 2 <= length){
            return false;
        }
        return true;
    }

    //   方法2：

    /**
     * 借鉴快排的分治思想
     * @param array
     * @param length
     * @return
     */
    public int MoreThanHalfNum2(int[] array, int length){
        if (array == null && length <= 0){
            new NullPointerException("数组异常");
        }
        int middle = length >> 1;    // 对 2 一定要敏感
        int start = 0;
        int end = length-1;
        ex19 e = new ex19();
        int index = e.Partition(array,length,start,end);
        //  这么做原因是因为过半的元素数组中间必是
        while (middle != index){
            if (index > middle){
                end = index -1;
                index = e.Partition(array,length,start,end);
            }
            else {
                start = index+1;
                index = e.Partition(array,length,start,end);
            }
        }
        int result = array[middle];
        if (!CheckMoreThanHalf(array,length,result)){
            new Exception("数组最多元素未过半");
        }
        return result;
    }

    public static void main(String[] args) {
        ex20 e = new ex20();
        int[] a = {1,2,3,2,2,2,5,4,2};
        System.out.println(e.MoreThanHalfNum2(a,9));
        /*int num = e.MOreThanHalfNum(a,9);
        if (e.CheckMoreThanHalf(a,9, num)){
            System.out.println("数组中出现次数过半的数为:\t"+ num);
        }
        else System.out.println("输入的数组不符合要求");*/
    }
}
