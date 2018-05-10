package OSInterview;

import java.util.Arrays;

/**
 * @Author: Allen
 * @Description:     银行家算法简易实现
 * @Date: Created in 15:17 2018/5/9
 * @Modify By:
 */
public class Banker {
    /**
     * 进程数
     */
    private static final int np = 5;
    /**
     * 资源种类个数
     */
    private static final int resourceTypes = 3;
    /**
     * 可用资源
     */
    private static int[] Available = {3, 3, 2};
    /**
     * 最大需求矩阵
     */
    private static int[][] Max = {{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}};
    /**
     * 最大分配矩阵
     */
    private static int[][] Allocation = {{0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
    /**
     * 需求矩阵
     */
    private static int[][] Need = {{7, 4, 3}, {1, 2, 2}, {6, 0, 0}, {0, 1, 1}, {4, 3, 1}};
    /**
     * 结果字符串数组
     */
    private static String[] result = new String[np];

    /**
     * 申请资源
     *
     * @param r
     * @param pid
     * @return
     */
    public static boolean requestResource(int[] r, int pid) {
        if (r.length < Available.length || pid < 0)
            return false;
        for (int i = 0; i < resourceTypes; i++) {
            if (r[i] < 0)       // 请求数据格式异常
                return false;
        }
        //  每个资源数都为零 不需要处理
        int[] zero = {0, 0, 0};
        boolean equals = Arrays.equals(zero, r);
        if (equals)
            return true;
        // 请求资源检查
        boolean request = isRequest(r, pid);
        if (!request)
            return false;
        // 修改相关资源
        changeResource(r, pid);
        // 修改已经分配过的进程的访问控制位
        boolean[] visit = new boolean[np];
        visit[pid] = true;
        int[] safeSequence = new int[resourceTypes];
        // 修改 Available 的副本
        for (int i = 0; i < resourceTypes; i++) {
            safeSequence[i] = Available[i] - r[i];
        }
        // 第一次记录
        safeSequence = assign(pid, safeSequence, 0);
        // 资源分配判断
        boolean isSafe = isSafe(safeSequence, visit);
        if (isSafe) {        // 安全序列 分配资源
            /*for (int i = 0; i < resourceTypes; i++) {
                Available[i] = safeSequence[i];
            }*/
            return true;
        } else {
            returnResource(pid,r);      // 资源回滚
            return false;
        }
    }

    /**
     *  假定分配
     * @param r
     * @param pid
     */
    private static void changeResource(int[] r, int pid) {
        for (int i = 0; i < resourceTypes; i++) {       // 修改 need
            Need[pid][i] -= r[i];
        }
        for (int i = 0; i < resourceTypes; i++) {       // 修改 Allocation
            Allocation[pid][i] += r[i];
        }
    }

    /**
     * 资源请求判断
     * @param r
     * @param pid
     * @return
     */
    public static boolean isRequest(int[] r, int pid) {
        for (int i = 0; i < resourceTypes; i++) {
            if (r[i] > Need[pid][i])
                return false;
        }
        for (int i = 0; i < resourceTypes; i++) {
            if (r[i] > Available[i])    //  只要有一个资源不满足，即失败
                return false;
        }
        return true;
    }

    /**
     * 资源分配失败时归回资源
     * @param pid
     * @param r
     */
    public static void returnResource(int pid ,int[] r){
        for (int i = 0; i < resourceTypes; i++) {       // 修改 need
            Need[pid][i] += r[i];
        }
        for (int i = 0; i < resourceTypes; i++) {       // 修改 Allocation
            Allocation[pid][i] -= r[i];
        }
    }

    /**
     * 判断是否是安全序列
     * @param r
     * @return
     */
    public static boolean isSafe(int[] r, boolean[] visit) {
        // 根据 Need 矩阵判断
        boolean flag = true;
        int count = 1;
        for (int i = 0; i < np; i++) {
            if (r[0] > Need[i][0] && !visit[i]) {
                for (int j = 1; j < resourceTypes; j++) {
                    if (r[j] < Need[i][j]) {     // 分配失败
                        return false;
                    }
                }
                if (flag) {  // 如果可以分配
                    r = assign(i, r, count);
                    visit[i] = true;
                    ++count;
                    if (count == np)
                        break;
                    i = -1;     // 每次都从头开始遍历
                }
            }
        }
        return true;
    }

    /**
     * 结果拼接
     * @param index
     * @param r
     * @param n
     * @return
     */
    private static int[] assign(int index, int[] r, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resourceTypes; i++) {       // work
            sb.append(r[i] + "\t");
        }
        sb.append("\t");
        for (int i = 0; i < resourceTypes; i++) {       // Need
            sb.append(Need[index][i] + "\t");
        }
        sb.append("\t");
        for (int i = 0; i < resourceTypes; i++) {       // Allocation
            sb.append(Allocation[index][i] + "\t");
        }
        int[] allocation = Allocation[index];
        // 变量副本预分配
        for (int i = 0; i < resourceTypes; i++) {
            r[i] += allocation[i];
        }
        sb.append("\t");
        for (int i = 0; i < resourceTypes; i++) {       // work + Allocation
            sb.append(r[i] + "\t");
        }
        result[n] = sb.toString();
        return r;
    }

    /**
     * 结果打印
     */
    static void print() {
        System.out.println("  work\t    \t\tneed\t \tAllocation\t  work+Allocation\t");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        int[] r = {1, 1, 1};
        int pid = 1;
        if (requestResource(r, pid))
            print();
        else System.out.println("分配失败");
    }
}
