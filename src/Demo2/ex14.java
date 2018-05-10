package Demo2;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class ex14 {

    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> fstack = new Stack<>();

    public boolean isStackList(int[] in, int[] outlist) {
        boolean flag = false;
        int inlen = in.length;
        int outListlen = outlist.length;
        if (inlen == 0 && outListlen == 0) new NullPointerException("数组为空");
        if (inlen != outListlen && stack.size() == 0) return false;

        // 找到弹出序列的第一个元素
        int index = 0;
        for (int i = 0; i < inlen; i++) {
            if (outlist[0] == in[i]) break;
            ++index;
        }
        // 将弹出序列在入栈序列中位置之前的元素全部压入辅助栈中
        for (int i = 0; i <= index; i++) {
            fstack.push(in[i]);
        }

        index = 0;
        for (int i = 0; i < outListlen && fstack != null; i++) {
            // 如果栈顶元素就是弹出元素集合，就弹出辅助栈中的元素
            if (fstack.peek() == outlist[i]) {
                fstack.pop();
            } else if (fstack.search(outlist[i]) < 0) { // 如果辅助栈中没有弹出序列，并且栈顶元素不等于弹出序列中的那个元素
                for (int j = 0; j < inlen; j++) {   // 遍历查找未入栈的元素的位置
                    if (outlist[i] == in[j]) break;
                    ++index;
                }
                fstack.push(in[index]);     // 将此元素入栈
                --i;    // 退后弹出序列元素的遍历
            }
            if (fstack != null) {   // 终止条件
                if (fstack.search(outlist[i]) >= 0 && fstack.peek() != outlist[i]) flag = false;
            }
        }
        if (fstack.size() == 0) flag = true;    // 辅助栈为空则说明
        return flag;
    }

    public static void main(String[] args) {
       /* stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 3, 2, 1};
        System.out.println(new ex14().isStackList(a, b));*/
       String s1 = new String("a");
       String s2 = s1;
        System.out.println(s1==s2);
    }
}
