package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckInclusion567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int windowSize = s1.length();
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            m1.put((char) ('a' + i), 0);
            m2.put((char) ('a' + i), 0);
        }
        for (int i = 0; i < windowSize; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            m1.put(c1, m1.get(c1) + 1);
            m2.put(c2, m2.get(c2) + 1);
        }
        for (int i = windowSize; i < s2.length(); i++) {
            if (m1.equals(m2)) return true;
            char c1 = s2.charAt(i);
            char c2 = s2.charAt(i - windowSize);
            m2.put(c1, m2.get(c1) + 1);
            m2.put(c2, m2.get(c2) - 1);
        }
        return m1.equals(m2);
    }
}
