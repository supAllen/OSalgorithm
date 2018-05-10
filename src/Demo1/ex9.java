package Demo1;

/**
 * 打印输出0-N个9之间的数字
 */
public class ex9 {

    // 方法一
    public void PrintToMaxNDigits(int n) {
        if (n <= 0) return;

        StringBuilder sb = new StringBuilder("0");
        for (int i = 1; i < n; i++) {
            sb.append("0");
        }

        int count = 1;
        while (!incrementNum(sb)) {
            if (count == 1) {
                System.out.println("0");
                count++;
            }
            PrintNum(sb.toString());
        }
    }


    /**
     * 给字符串数字加一
     *
     * @param str
     * @return
     */
    public boolean incrementNum(StringBuilder str) {
        // 判断是否是最后一个数字
        boolean isOverflow = false;
        // 判断是否有进位
        int ntakeOver = 0;
        // 长度
        int nlength = str.length();
        for (int i = nlength - 1; i >= 0; --i) {
            // 每一位的数字是多少
            int nsum = str.charAt(i) - '0' + ntakeOver;
            // 如果是第一位的第一个数字就加一
            if (i == nlength - 1) nsum++;
            // 若果产生进位
            if (nsum >= 10) {
                // 如果是最后一位，并且产生进位
                if (i == 0) {
                    isOverflow = true;
                }
                // 不是最后一位，但是产生进位
                else {
                    nsum -= 10;
                    ntakeOver = 1;
                    // 修改相关位的字符
                    str.setCharAt(i, (char) ('0' + nsum));
                }
            } else {
                // 修改相关位的字符
                str.setCharAt(i, (char) ('0' + nsum));
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 打印数字串
     */
    public void PrintNum(String str) {
        // 区别第一位是否是0，并且保证第一位不是0的情况下，后面的为可以是0
        boolean isbegining0 = true;
        int nlength = str.length();
        for (int i = 0; i < nlength; ++i) {
            // 保证遇到的第一位不是0，如果是0就循环
            if (isbegining0 && str.charAt(i) != '0') isbegining0 = false;
            // 在首位非0 的情况下，其他位可以为0
            if (!isbegining0) System.out.print(str.charAt(i));
        }
        System.out.println('\t');
    }

    // 方法二   数字全排列法（递归）
    public void PrintToMaxNDigits2(int n) {
        if (n <= 0) return;
        StringBuilder sb = new StringBuilder("0");
        for (int i = 1; i < n; i++) {
            sb.append("0");
        }

        for (int i = 0; i < 10; i++) {
            // 这里是设置第一位
            sb.setCharAt(0, (char) (i + '0'));
            PrintToMaxDigistsRecursively(sb, sb.length(), 0);
        }
    }

    // 递归设置除了第一位的其他位，然后和第一位全排列
    public void PrintToMaxDigistsRecursively(StringBuilder sb, int length, int index) {
        // 这里需要位数判断
        if (index == length - 1) {
            PrintNum(sb.toString());
            return;
        }

        for (int i = 0; i < 10; i++) {
            // 如果不止一位数的话，就需要在这里设置后面的位
            sb.setCharAt(index + 1, (char) (i + '0'));
            PrintToMaxDigistsRecursively(sb, length, index + 1);
        }
    }

    public static void main(String[] args) {
        //new ex9().PrintToMaxNDigits2(2);
        String s = "aaa";
        s = "nnn";
        String s2 = new String("bbb");
        s2 = "ccc";
        System.out.println(s2);
    }
}
