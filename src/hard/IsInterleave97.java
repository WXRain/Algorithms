package hard;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 
 * 示例 1:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" 输出: true 示例 2:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" 输出: false
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author rain
 */
public class IsInterleave97 {
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null && s2 == null)
			return false;
		int n1 = s1.length(), n2 = s2.length();
		if (n1 + n2 != s3.length())
			return false;
		boolean[][] dp = new boolean[n1 + 1][n2 + 1];
		dp[0][0] = true;
		for (int i = 1; i <= n1; i++) {
			dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
		}
		for (int i = 1; i <= n2; i++) {
			dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
		}
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
						|| dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
			}
		}
		return dp[n1][n2];
	}

	public static void main(String[] args) {
		System.out.println(isInterleave("aabd", "abdc", "aabdbadc"));
	}
}
