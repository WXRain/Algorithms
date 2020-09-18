package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermuteUnique47 {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();

        if (nums == null || nums.length == 0) return new ArrayList<>(res);

        Set<List<Integer>> temp = new HashSet<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            for (List<Integer> list : res) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> l = new ArrayList<>(list);
                    l.add(i, num);
                    temp.add(l);
                }
            }
            res = temp;
            temp = new HashSet<>();
        }
        return new ArrayList<>(res);
    }
}
