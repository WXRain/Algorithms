package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordPattern290 {
    public static boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        char[] chs = pattern.toCharArray();
        if (ss.length != chs.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i]) && !map.get(chs[i]).equals(ss[i])) return false;
            if (!map.containsKey(chs[i])) {
                if (map.containsValue(ss[i])) return false;
                map.put(chs[i], ss[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        wordPattern("abba",
                "dog cat cat dog");
    }
}
