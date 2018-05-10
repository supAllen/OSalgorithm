package Demo2;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 树相关的题目
 */

public class ex15 {

    /**
     * 树的结点的定义
     *
     * @param <T>
     */
    private static class TreeNode<T> {
        T value;

        public TreeNode(T value) {
            this.value = value;
            left = null;
            right = null;
        }

        TreeNode<T> left;
        TreeNode<T> right;
    }

    /**
     * 双向链表的定义
     *
     * @param <T>
     */
    private static class doubleList<T> {
        T value;

        public doubleList(T value) {
            this.value = value;
            pNext = null;
            pPre = null;
        }

        doubleList<T> pNext;
        doubleList<T> pPre;
    }

    /**
     * 二叉探索树转换为双向链表
     *
     * @param root
     * @return
     */
    public TreeNode<Integer> ConvertBSTToBiList(TreeNode<Integer> root) {
        if (root == null)
            return null;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> p = root;
        TreeNode<Integer> pre = null;  // 用于保存中序遍历中的前一个结点
        boolean isFirst = true;
        while (p != null || !stack.isEmpty()) {
            // 找到第一个非空的结点
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop(); // 此处弹出来的是中序遍历的结点
            if (isFirst) {    // 第一次设置根
                root = p;
                pre = root;
                isFirst = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
    }

    private static Stack<TreeNode<Integer>> stack = new Stack<>();

    /**
     * 二叉树的层序遍历
     *
     * @param root
     */
    public void lavelOrderTraverse(TreeNode<Integer> root) {
        if (root == null) new NullPointerException("树为空");
        ArrayDeque<TreeNode<Integer>> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            System.out.println(deque.getFirst().value);
            TreeNode<Integer> t = deque.poll();
            if (t.left != null) deque.add(t.left);
            if (t.right != null) deque.add(t.right);
        }
    }

    /**
     * 二叉树的创建
     *
     * @param array
     * @param index
     * @return
     */
    public TreeNode<Integer> createTree(int[] array, int index) {
        TreeNode<Integer> treeNode = null;
        if (index < array.length) {
            treeNode = new TreeNode(array[index]);
            treeNode.left = createTree(array, index * 2 + 1);
            treeNode.right = createTree(array, index * 2 + 2);
        }
        return treeNode;
    }

    /**
     * 二叉树的先序遍历
     *
     * @param treeNode
     */
    public void print(TreeNode<Integer> treeNode, StringBuilder sb) {
        if (treeNode != null) {
            System.out.print(treeNode.value + "\t");
            sb.append(treeNode.value);
            print(treeNode.left, sb);
            print(treeNode.right, sb);
        }
    }

    /**
     * 二叉树中和为某一值的路径
     *
     * @param root
     */

    public void Findpath(TreeNode<Integer> root, int result) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                int sum = 0;
                for (int i = 0; i < stack.size(); i++) {
                    sum += stack.get(i).value;
                }
                if (sum + root.value == result) {
                    System.out.println("值为" + result + "的路径为： ");
                    for (int i = 0; i < stack.size(); i++) {
                        System.out.print(stack.get(i).value + "->");
                    }
                    System.out.print(root.value);
                    System.out.println();
                }
                return;
            }
            stack.push(root);
            if (root.left != null) {
                Findpath(root.left, result);
            }
            if (root.left != null) {
                Findpath(root.right, result);
            }
            stack.pop();
        }
    }

    /**
     * 树的深度
     *
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        int left = TreeDepth(root.left);
        int rigth = TreeDepth(root.right);
        return left > rigth ? (left + 1) : (rigth + 1);
    }

    /**
     * 判断一棵树是否是平衡二叉树
     *
     * @param root
     * @param dept
     * @return
     */
    public boolean isBalanced(TreeNode<Integer> root, int[] dept) {       // 数组是对象，用对象代替引用
        if (root == null) {
            dept[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = left[0] - right[0];
            if (diff <= 1 || diff >= -1) {
                dept[0] = (left[0] > right[0] ? left[0] : right[0]) + 1;
                return true;
            }
        }
        return false;
    }

    /**
     * 二叉树的镜像
     *
     * @param root
     */
    public void Treejx(TreeNode<Integer> root) {
        if (root == null) return;
        TreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
        Treejx(root.left);
        Treejx(root.right);
    }

    /**
     * 二叉树是否对称
     *
     * @param root
     * @return
     */
    public boolean isSymmetrical(TreeNode<Integer> root) {
        if (root == null) return false;
        StringBuilder sb = new StringBuilder();
        print(root, sb);
        Treejx(root);
        StringBuilder sb2 = new StringBuilder();
        print(root, sb2);
        System.out.println();
        System.out.println(sb + "\n" + sb2);
        String s1 = sb.toString();
        String s2 = sb2.toString();
        if (s1.equals(s2)) return true;
        else return false;
    }

    /**
     * 序列化二叉树
     *
     * @param root
     * @param sb
     */
    public void Serialize(TreeNode<Integer> root, StringBuilder sb) {
        if (root == null) {
            sb.append("$");
            return;
        }
        sb.append(root.value);
        Serialize(root.left, sb);
        Serialize(root.right, sb);
    }

    /**
     * 反序列化二叉树
     * @param node
     * @param str
     * @param index
     */
    public void DeSerialize(TreeNode<Integer> node, String str,int index) {
        if (str == null) return;
        if (str.charAt(index) == '$'){
            node = null;
        }
        else {
            node = new TreeNode<>((int) str.charAt(index));
            DeSerialize(node.left, str,++index);
            DeSerialize(node.right, str,++index);
        }
    }

    /**
     * 二叉探索树中第K个结点
     * @param root
     * @param sb
     */
    public void KthNode(TreeNode<Integer> root,StringBuilder sb){
        if (root == null) return;
        KthNode(root.left,sb);
        sb.append(root.value);
        KthNode(root.right,sb);
    }

    public static void main(String[] args) {
        ex15 e = new ex15();
        //int[] a = {1, 2, 3, 4, 5, 6, 7};
        /*
        TreeNode<Integer> t = e.createTree(a, 0);
        e.print(t);
        e.lavelOrderTraverse(t);
        */

        /*int[] b = {10, 5, 12, 4, 7};
        TreeNode<Integer> root = e.createTree(b, 0);
        //e.print(root);
        e.Findpath(root, 22);*/
        /*int[] a = {10, 6, 14, 4, 8, 12, 16};
        TreeNode<Integer> root = e.createTree(a, 0);
        System.out.println(e.TreeDepth(root));
        int[] dept = new int[1];
        System.out.println(e.isBalanced(root,dept));*/
        /*TreeNode<Integer> conroot = e.ConvertBSTToBiList(root);
        TreeNode<Integer> r = conroot;
        for (; r != null; r = r.right) {
            System.out.println(r.value);
        }*/

        //int[] a = {8, 6, 6, 5, 7, 7, 5};
        /*TreeNode<Integer> root = e.createTree(a, 0);
        StringBuilder sb = new StringBuilder();
        e.print(root,sb);
        System.out.println();
        e.Serialize(root,sb);
        TreeNode<Integer> droot = null;
        e.DeSerialize(droot,sb.toString(),0);
        e.print(root,sb);*/
        int[] b = {5,3,7,2,4,6,8};
        TreeNode<Integer> root = e.createTree(b,0);
        StringBuilder sb= new StringBuilder();
        e.KthNode(root,sb);
        System.out.println(sb.toString().toCharArray()[3-1]);
        //System.out.println(e.isSymmetrical(root));
        /*StringBuilder sb = new StringBuilder();
        e.print(root,sb);
        System.out.println();
        sb = new StringBuilder();
        e.Treejx(root);
        e.print(root,sb);*/
    }
}
