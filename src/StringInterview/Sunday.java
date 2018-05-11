package OSInterview;

/**
 * @Author: Allen
 * @Description:    字符串匹配——Sunday算法
 *
 * 参考博客链接： https://blog.csdn.net/q547550831/article/details/51860017
 *
 * @Date: Created in 13:28 2018/5/11
 * @Modify By:
 */
public class Sunday {

    public static void sunday(String origin, String pattern){
        assert origin != null && pattern != null;
        int ol = origin.length();
        int pl = pattern.length();
        assert pl < ol;
        int index = 0;
        while (index <= ol-pl){
            int ori = index;
            for (int i = pl-1+index; i >= index; --i) {
                if (i < ol && pattern.charAt(i-index) != origin.charAt(i)){
                    index = i+1;
                    break;
                }
            }
            if (index == ori){
                System.out.println("find str index : "+index);
                return;
            }
        }
        if (index>=ol-pl)
            System.out.println("no find");
    }

    public static void main(String[] args) {
        String ostr = "gagewgwe";
        String pstr = "gwagweg";
        sunday(ostr,pstr);
    }
}
