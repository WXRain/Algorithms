package hard;

/**
 *给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 示例 1:
 *
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 *
 * 输入: "abcd"
 * 输出: "dcbabcd"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestPalindrome214 {
    /**
     * 先逆序，然后截取逆序后的前i个字符拼接到原串上，取满足回文条件最小的i
     * @param s 字符串
     * @return 最短回文字符串
     */
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder(s);
        String rs = sb.reverse().toString();
        int i = 0;
        while (!(rs.substring(i).equals(s.substring(0, s.length() - i)))) {
            i++;
        }
        return rs.substring(0, i) + s;
    }
}
