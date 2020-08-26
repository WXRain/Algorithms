package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations17 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        char[][] l = {{}, {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};
        List<String> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = digits.charAt(i) - '0';
            for (int j = 0; j < l[x].length; j++) {
                for (String s : list) {
                    temp.add(s + l[x][j]);
                }
            }
            list = temp;
            temp = new ArrayList<>();
        }
        return list;
    }
}
