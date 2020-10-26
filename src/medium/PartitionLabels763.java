package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionLabels763 {
    public List<Integer> partitionLabels(String S) {
        int[] pos = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            pos[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int pre = -1, i = 0, bound = 0;
        while (i < len) {
            if (i <= bound) {
                bound = Math.max(bound, pos[S.charAt(i) - 'a']);
            }
            if (i == bound) {
                res.add(i - pre);
                pre = i;
                bound++;
            }
            i++;
        }
        return res;
    }
}