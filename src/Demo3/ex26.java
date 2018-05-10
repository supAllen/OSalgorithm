package Demo3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Allen
 * @Description: 第一个只出现一次的字符
 * @Date: Created in 13:46 2018/1/30
 * @Modify By:
 */
public class ex26 {

    public char FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)           // ""  与 null 区别：  "" 有地址  null  没有地址
            new NullPointerException("字符串输入异常");
        if (str.length() == 1) {
            return str.charAt(0);
        }
        Map<Character, Integer> map = new HashMap<>(256);
        StringBuilder sb = new StringBuilder();
        for (char c :
                str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
                sb.append(c);
            } else {
                // 修改map中Value值
                map.compute(c, (k, v) -> ++v);
            }
        }
        char c = ' ';
        for (char cc :
                sb.toString().toCharArray()) {
            if (map.get(cc) == 1){
                c = cc;
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
       /* Map<Character,Integer> map = new HashMap<>(256);
        map.put('a',1);
        map.compute('a',(k,v) -> ++v);
        System.out.println(map.get('a'));*/

        ex26 e = new ex26();
        System.out.println(e.FirstNotRepeatingChar("go"));
    }
}
