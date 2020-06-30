package medium;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 
 * 示例 1:
 * 
 * 输入: A: [1,2,3,2,1] B: [3,2,1,4,7] 输出: 3 解释: 长度最长的公共子数组是 [3, 2, 1]。 说明:
 * 
 * 1 <= len(A), len(B) <= 1000 0 <= A[i], B[i] < 100
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author rain
 */
public class FindLength718 {
	public int findLength(int[] A, int[] B) {

		int lenA = A.length;
		int lenB = B.length;

		int[][] dp = new int[lenA + 1][lenB + 1];

		for (int i = 1; i <= lenA; i++) {
			for (int j = 1; j <= lenB; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}
		int max = dp[0][0];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}
