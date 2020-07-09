package medium;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 示例:
 * 
 * 输入: [1,2,3,0,2] 输出: 3 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author rain
 */
public class MaxProfit309 {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len <= 1)
			return 0;

		if (len == 2 && prices[0] >= prices[1])
			return 0; // 特殊情况处理
		else if (len == 2 && prices[0] < prices[1])
			return prices[1] - prices[0]; // 特殊情况处理

		int[][] dp = new int[len][2];

		dp[0][0] = 0; // 第一天不持有股票
		dp[0][1] = -prices[0]; // 第一天持有股票
		dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);// 第二天不持有股票
		dp[1][1] = Math.max(dp[0][0] - prices[1], dp[0][1]);// 第二天持有股票

		for (int i = 2; i < len; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);// 第i天不持有股票
			dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);// 第i天持有股票
		}

		return dp[len - 1][0];
	}
}
