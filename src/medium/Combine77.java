package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k == 0) return result;
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                result.add(temp);
            }
            return result;
        }
        if (k == n) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                temp.add(i);
            }
            result.add(temp);
            return result;
        }
        List<List<Integer>> answer = combine(n - 1, k);
        List<List<Integer>> x = combine(n - 1, k - 1);
        for (List<Integer> item : x) {
            item.add(n);
            answer.add(item);
        }
        return answer;
    }

    public static void main(String[] args) {
        combine(4, 2);
    }
}
