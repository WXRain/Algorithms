package easy;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * <p>
 * 输出：
 * e
 * <p>
 * 解释：
 * 'e' 是那个被添加的字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTheDifference389 {
    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        if (s == null || s.length() == 0) return t.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) return (char) ('a' + i);
        }
        return 'a';
    }
}
