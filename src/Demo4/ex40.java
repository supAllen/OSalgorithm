package Demo4;

/**
 * @Author: Allen
 * @Description:  堆排
 * @Date: Created in 14:41 2018/2/9
 * @Modify By:
 */
public class ex40 {
    /**
     * 最大堆的一次过程
     * @param num
     * @param root
     */
    private void MaxHeap(int[] num, int root, int numSize){
        if (num == null) return;
        int rootValue = num[root];
        int left = (root<<1)+1;
        while (left <= numSize){    // 为调整一个数所带来的其他小顶堆的调整带来可能
            if (left < numSize) // 有右孩子的情况下
                if (num[left] < num[left+1])  // 右孩子大于左孩子的情况下
                    left = left+1;  // 定位到右孩子上
            if (rootValue < num[left]){ // 左孩子值大于根结点
                num[root] = num[left];  // 更新根结点
                root = left;    // 更新根结点
                left = (root<<1)+1;    // 更新左节点
            }
            else left = numSize+1;  // 如果不需要更新堆结点，就需要这句话来退出循环
        }
        num[root] = rootValue;  // 最后更新没有更新的那一个结点
    }

    /**
     * 最大堆的构建
     * @param num
     * @param length
     */
    private void BuildHeap(int[] num,int length){
        if (num == null) return;
        for (int i = (length>>1)-1; i >=0 ; --i) {
            MaxHeap(num,i,length-1);
        }
    }

    /**
     * 堆排
     * @param num
     * @param length
     */
    public void HeapSort(int[] num,int length){
        if (num == null) return;
        BuildHeap(num,length);
        for (int i = length-1; i >=0 ; --i) {
            num[i] = num[0] ^ num[i];
            num[0] = num[0] ^ num[i];
            num[i] = num[0] ^ num[i];
            MaxHeap(num,0,i-1); // 从最后一个元素往前交换，而不是固定的最后一个交换
        }
    }

    public static void main(String[] args) {
        int[] num = {3,6,7,5,4,8,9,2,13,17,1,123,234,345,345436,445,33446};
        new ex40().HeapSort(num,num.length);
        for (int a :
                num) {
            System.out.println(a+"\t");
        }
    }
}
