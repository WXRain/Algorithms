package hard;

import java.util.Arrays;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCut132 {
    public int minCut(String s) {
        if (s == null || s.length() < 2) return 0;
        int length = s.length();
        int[] dp = new int[length];
        Arrays.fill(dp, length - 1);
        for (int i = 0; i < length; i++) {
            mincutHelper(s, i, i, dp);//以当前位置向外扩展，总数为奇数
            mincutHelper(s, i, i + 1, dp);//以当前位置向外扩展，总数为偶数
        }
        return dp[length - 1];
    }
    //找到以i开始以j结尾的最长回文子串，更新dp数组为需要的最少分割次数
    public void mincutHelper(String s, int i, int j, int[] dp) {
        int length = s.length();
        while (i >= 0 && j < length && s.charAt(i) == s.charAt(j)) {
            //在以当前为中心的最长回文子串边界位置取最小的分割数
            dp[j] = Math.min(dp[j], (i == 0 ? -1 : dp[i - 1]) + 1);
            i--;
            j++;
        }
    }
}
