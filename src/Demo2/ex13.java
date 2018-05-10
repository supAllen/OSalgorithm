package Demo2;

import java.util.Stack;

/**
 *  包含min函数的栈
 */
public class ex13 {
    private static Stack<Integer> fstack = new Stack<>();
    private static Stack<Integer> stack = new Stack<>();

    public void push(int n){
        stack.push(n);
        if (fstack.size() <= 0 || fstack.peek() > n){
            fstack.push(n);
        }else if (fstack.peek() < n){
            fstack.push(fstack.peek());
        }
    }

    public int pop(){
        if (stack.peek() == null) new NullPointerException("栈为空");
        if (fstack.peek() == null) new NullPointerException("辅助栈为空");
        fstack.pop();
        return stack.pop();
    }

    public int min(){
        if (fstack.peek() == null) new NullPointerException("辅助栈为空");
        return fstack.peek();
    }

    public static void main(String[] args) {
        ex13 e = new ex13();
        e.push(3);
        e.push(5);
        e.push(2);
        e.pop();
        e.pop();
        System.out.println(e.min());
    }
}
