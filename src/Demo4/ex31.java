package Demo4;

/**
 * @Author: Allen
 * @Description:    翻转单词顺序 VS  左旋转字符串
 * @Date: Created in 10:15 2018/2/2
 * @Modify By:
 */
public class ex31 {
    /**
     * 单词翻转
     * @param str
     * @param sb
     * @param p sb 的开始位置
     * @param l sb 的结束位置
     */
    public void Reverse(String str, StringBuilder sb, int p,int l){
        if (str == null || sb == null || str.length() == 1)
            return;
        do {
            char cp = str.charAt(p);
            char cl = str.charAt(l);
            sb.setCharAt(p,cl);
            sb.setCharAt(l,cp);
            ++p;
            --l;
        }while (p < l);
    }

    /**
     * 整个句子翻转
     * @param str
     * @param length
     * @return
     */
    public String ReverseSentence(String str, int length){
        if (str == null || length == 0)
            return null;
        StringBuilder sb = new StringBuilder(str);
        int preIndex = 0;
        int lastIndex = length-1;
        // 先全部翻转
        Reverse(str,sb,preIndex,lastIndex);
        String s2 = sb.toString();   // 保存翻转之后的字符串
        // 单词翻转
        preIndex = 0;
        lastIndex = 0;
        int pre = 0;
        int last = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            if (s2.charAt(i) != ' '){
                ++lastIndex;
            }
            else {
                String s = s2.substring(preIndex,lastIndex);
                sb = new StringBuilder(s);
                pre = preIndex;
                last = lastIndex-1;
                Reverse(s,sb,0,last-pre);
                preIndex = lastIndex+1;
                lastIndex = lastIndex+1;
                result.append(sb).append(" ");
            }
        }
        result.append(s2.charAt(length-1));
        return result.toString();
    }

    /**
     * 字符串的左旋操作
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str, int n){
        if (str == null || str.length() == 0 || n > str.length())
            return null;
        if (n == str.length())
            return str;
        //整体翻转
        StringBuilder sb = new StringBuilder(str);
        Reverse(str,sb,0,str.length()-1);
        // 翻转后的字符串
        String s = sb.toString();
        // 存储结果
        StringBuilder result = new StringBuilder();
        // 两个部分的字符串
        StringBuilder s1;
        // 前半部分的翻转
        s1 = new  StringBuilder(s.substring(0,s.length()-n));
        Reverse(s,s1,0,s.length()-n-1); // 用翻转后的字符串
        result.append(s1.toString());
        // 后半部分翻转
        s1 = new StringBuilder(s.substring(s.length()-n));
        Reverse(str,s1,0,n-1);  // 用原始的字符串
        result.append(s1.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        ex31 e = new ex31();
        System.out.println(e.ReverseSentence("I am a Student.","I am a Student.".length()));
        System.out.println(e.LeftRotateString("asdfghj",2));
    }
}
