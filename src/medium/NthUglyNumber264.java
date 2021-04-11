package medium;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *
 *
 * 提示：
 *
 * 1 <= n <= 1690
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthUglyNumber264 {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int y2 = 0, y3 = 0, y5 = 0;
        for (int i = 1; i < n; i++) {
            int r2 = res[y2] * 2;
            int r3 = res[y3] * 3;
            int r5 = res[y5] * 5;
            int cur = Math.min(r2, Math.min(r3, r5));
            if (r2 == cur) {
                y2++;
            }
            if (r3 == cur) {
                y3++;
            }
            if (r5 == cur) {
                y5++;
            }
            res[i] = cur;
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        new NthUglyNumber264().nthUglyNumber(10);
    }
}
