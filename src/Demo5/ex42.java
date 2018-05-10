package Demo5;

/**
 * @Author: Allen
 * @Description: 矩阵中的路径
 * @Date: Created in 22:09 2018/2/10
 * @Modify By:
 */
public class ex42 {

    /**
     * @param matrix  矩阵
     * @param rows  矩阵的行
     * @param cols  矩阵的列
     * @param str   路径数组
     * @return
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null)
            return false;
        boolean[] visit = new boolean[rows * cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, i, j, 0, rows, cols, str, visit))
                    return true;
            }
        }
        return false;
    }

    /**
     * @param matrix    矩阵
     * @param i     矩阵中某一个点的行下标
     * @param j     矩阵中某一个点的列下标
     * @param k     路径数组的下标
     * @param row   矩阵的行
     * @param col   矩阵的列
     * @param str   路径数组
     * @param visit 访问控制数组
     * @return
     */
    public static boolean hasPathCore(char[] matrix, int i, int j, int k, int row, int col, char[] str, boolean[] visit) {
        // 对于给定行数和列数得到其在矩阵中的下标
        int index = i * col + j;
        //判断合法性
        if (i < 0 || i >= row || j < 0 || j >= col || str[k] != matrix[index] || visit[index])
            return false;
        visit[index] = true;
        // 如果递归到最后一个位置的字符，则表明前面位置的字符都在矩阵中找到了对应的位置
        if (k == str.length - 1)
            return true;
        // 回溯过程
        if (hasPathCore(matrix, i + 1, j, k + 1, row, col, str, visit)
                || hasPathCore(matrix, i - 1, j, k + 1, row, col, str, visit)
                || hasPathCore(matrix, i, j - 1, k + 1, row, col, str, visit)
                || hasPathCore(matrix, i, j + 1, k + 1, row, col, str, visit))
            return true;
        else {   // 如果相邻格子的字符都没有匹配到下一个字符，则需要回到前一个格子，从而需要把把位置的状态重新设定为未访问
            --k;
            visit[index] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[] cs = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'b','c','c','e','d'};
        char[] str2 = {'a','b','c','b'};
        System.out.println(hasPath(cs,3,0,str2));
    }
}
