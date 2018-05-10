package Demo2;

/**
 * 字符串的全排列
 */
public class ex18 {

    public void getAllstr(String str) {
        if (str.length() <= 0) return;
        int len = 1;
        for (int i = str.length(); i >= 1; --i) {
            len *= i;
        }
        String[][] strings = new String[str.length()][len];
        strings[0][0] = String.valueOf(str.charAt(0));
        StringBuilder sb;
        int n = 0;
        int dept = 0;
        // 字符串个数减一
        for (int i = 1; i < str.length(); ++i) {
            // 上一层字符串的个数（根据上一层的字符串产生这一层）
            for (int j = 0; j <= n; ++j) {
                sb = new StringBuilder(strings[i - 1][j]);
                // 产生的字符串的个数
                for (int k = dept; k <= i + dept; ++k) {
                    strings[i][k] = sb.insert(k-dept, str.charAt(i)).toString();
                    sb = new StringBuilder(strings[i - 1][j]);
                }
                if (n > 0)
                    dept += (i + 1);
            }
            ++n;
        }
        for (int i = 0; i < len; i++) {
            System.out.println(strings[str.length() - 1][i]);
        }
    }

    public static void main(String[] args) {
        ex18 e = new ex18();
        e.getAllstr("abc");
    }
}
