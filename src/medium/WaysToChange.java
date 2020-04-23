package medium;
/**
 * 
 *@author rain
硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)

示例1:

 输入: n = 5
 输出：2
 解释: 有两种方式可以凑成总金额:
5=5
5=1+1+1+1+1
示例2:

 输入: n = 10
 输出：4
 解释: 有四种方式可以凑成总金额:
10=10
10=5+5
10=5+1+1+1+1+1
10=1+1+1+1+1+1+1+1+1+1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WaysToChange {
	//动态规划
	public int waysToChange(int n) {
		int[] dp = new int [n+1];
		int mod = 1000000007;
		int[] tokens = {25,10,5,1};
		for(int i = 0; i < tokens.length; i++){
			for(int j = 1; j <= n; j++){
				if(tokens[i] == j) dp[j] = (dp[j] + 1) % mod;//硬币等于当前面额
				else if(tokens[i] < j) dp[j] = (dp[j] + dp[j-tokens[i]]) % mod;//硬币大于当前面额
				//硬币小于当前面额省略
			}
		}
		return dp[n];
    }
}
