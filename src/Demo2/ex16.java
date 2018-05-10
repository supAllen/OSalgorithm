package Demo2;

import java.util.Arrays;

/**
 * 二叉搜索树的后序遍历序列
 */
public class ex16 {

    public boolean isTreeXL(int[] a, int length){
        if (a==null && length <= 0) return false;
        // 左子树结点大于根结点的下标
        int root = a[length-1];
        int i = 0,j = 0;
        // 要除去最后一个根结点  所以 length-1
        for (; i < length-1; ++i) {
            if (root < a[i]) break;
        }
        // 右子树中找小于根结点
        for (j = i; j < length-1; ++j) {
            if (root > a[j]) return false;
        }
        // 递归查看子树是否满足条件
        boolean leftflag  = true;
        if (i > 0) leftflag = isTreeXL(a,i);
        boolean rightflag = true;
        int[] b = new int[length-i-1];
        System.arraycopy(a,i,b,0,length-i-1);
        Arrays.toString(b);
        if (i < length-1) rightflag = isTreeXL(b,length-i-1);
        return leftflag && rightflag;
    }

    public static void main(String[] args) {
        int[] a = {7,4,6,5};
        int[] b = {5,7,6,9,11,10,8};
        System.out.println(new ex16().isTreeXL(b,7));
    }
}
