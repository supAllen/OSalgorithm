package Demo2;

/**
 * 旋转矩阵打印
 */
public class ex12 {
    public void PrintMatrixClockwisely(int[][] a, int columns, int rows){
        if (a==null && columns<=0 && rows <= 0) new Exception("输入异常");
        int start = 0;
        while (columns > 2*start && rows > 2*start){
            PrintMatrixInCircle(a,columns,rows,start);
            ++start;
        }
    }

    public void PrintMatrixInCircle(int[][] a, int columns, int rows, int start){
        int endx = columns-1-start;
        int endy = rows-1-start;
        // 从左到右打印
        for (int i = start; i <= endy; ++i) {
            System.out.print(a[start][i]+"    ");
        }
        // 从上到下打印
        if (endy > start){
            for (int i = start+1; i <= endx; ++i) {
                System.out.print(a[i][endy]+"    ");
            }
        }
        // 从右到左打印
        if (start < endy && start < endx){
            for (int i = endy-1; i >= start; --i) {
                System.out.print(a[endx][i]+"    ");
            }
        }
        // 从下往上打印
        if (start < endy-1 && start < endx){
            for (int i = endx-1; i >= start+1; --i) {
                System.out.print(a[i][start]+"    ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1}};
        new ex12().PrintMatrixClockwisely(a,a.length,a[0].length);
    }
}
