package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqChar387 {
    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        List<Character> list = new ArrayList<>();
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
                nums[list.indexOf(c)]++;
            } else {
                nums[list.indexOf(c)]++;
            }
        }
        int i;
        for (i = 0; i < 26; i++) {
            if (nums[i] == 1) break;
        }
        if (i == 26 || i >= list.size()) return -1;
        char c = list.get(i);
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == c) return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        firstUniqChar("leetcode");
    }
}
