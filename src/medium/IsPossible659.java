package medium;

import java.util.HashMap;
import java.util.Map;

/**
 *给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 *
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 * 提示：
 *
 * 输入的数组长度范围为 [1, 10000]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPossible659 {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.replace(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        for (int num : nums) {
            if (countMap.get(num) == 0) continue;
            countMap.replace(num, countMap.get(num) - 1);
            if (endMap.containsKey(num - 1) && endMap.get(num - 1) > 0) {
                endMap.replace(num - 1, endMap.get(num - 1) - 1);
                if (endMap.containsKey(num)) {
                    endMap.replace(num, endMap.get(num) + 1);
                } else {
                    endMap.put(num, 1);
                }

            } else if (countMap.containsKey(num + 1) && countMap.get(num + 1) > 0 && countMap.containsKey(num + 2) && countMap.get(num + 2) > 0) {
                countMap.replace(num + 1, countMap.get(num + 1) - 1);
                countMap.replace(num + 2, countMap.get(num + 2) - 1);
                if (endMap.containsKey(num + 2)) {
                    endMap.replace(num + 2, endMap.get(num + 2) + 1);
                } else {
                    endMap.put(num + 2, 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
