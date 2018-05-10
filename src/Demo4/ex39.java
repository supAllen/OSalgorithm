package Demo4;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Allen
 * @Description: 字符流中第一个不重复的字符
 * @Date: Created in 10:37 2018/2/7
 * @Modify By:
 */
public class ex39 {
    public static void FirstAppearingOne(String str, int length) {
        if (str == null || length < 1)
            return;
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0;
        StringBuilder sb= new StringBuilder();
        do {
            // 查看哈希表中有没有这个元素
            if (map.containsKey(str.charAt(index)))
                map.compute(str.charAt(index), (k, v) -> ++v);
            else{
                // put操作会对key重新进行排序
                map.put(str.charAt(index), 1);
                sb.append(str.charAt(index));
            }
            ++index;
        } while (index != length);
        for (char c :
                sb.toString().toCharArray()) {
            if (map.get(c) == 1){
                System.out.println(c);
                break;
            }
        }
    }

    public static void main(String[] args) {
        FirstAppearingOne("go", "go".length());
    }
}
