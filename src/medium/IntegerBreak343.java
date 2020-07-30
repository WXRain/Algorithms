package medium;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerBreak343 {
    /**
     * 求函数y=(n/x)^x(x>0)的最大值，可得x=e时y最大，
     * 但只能分解成整数，故x取2或3，由于6=2+2+2=3+3，
     * 显然2^3=8
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n == 1 || n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int a = 1;
        while (n > 4) {
            a = a * 3;
            n -= 3;
        }
        return (a * n);
    }
}
