package medium;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MonotoneIncreasingDigits738 {
    public int monotoneIncreasingDigits(int N) {
        String s = N + "";
        char[] chs = s.toCharArray();
        int i;
        for (i = 1; i < chs.length; i++) {
            if (chs[i] < chs[i - 1]) {
                break;
            }
        }
        if (i == chs.length) {
            return N;
        }
        chs[i - 1]--;
        for (; i < chs.length; i++) {
            chs[i] = '0' + 9;
        }
        int res = 0;
        int ra = 1;
        for (i = chs.length - 1; i >= 0; i--) {
            res += (chs[i] - '0') * ra;
            ra *= 10;
        }
        return monotoneIncreasingDigits(res);
    }
}
