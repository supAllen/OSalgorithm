package Demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 交叉链表寻找交叉点
 */
public class ex4 {
    public static int getpoint(List<Integer> list1, List<Integer> list2){
        if (list1 == null || list2 == null) return -1;
        int len = list1.size() > list2.size() ? list1.size() : list2.size();
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        for (int i = 0; i < list1.size(); i++) {
            stack1.push(list1.get(i));
        }
        for (int i = 0; i < list2.size(); i++) {
            stack2.push(list2.get(i));
        }

        int a = Integer.MAX_VALUE;
        int s1 = stack1.pop(), s2 = stack2.pop();
        for (int i = 0; i < len; i++) {
            if (s1 != s2)   break;
            a = s1;
            s1 = stack1.pop();
            s2 = stack2.pop();
        }
        return a;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(6);
        list1.add(9);
        list2.add(1);
        list2.add(4);
        list2.add(6);
        list2.add(9);
        System.out.println(getpoint(list1,list2));
    }
}
