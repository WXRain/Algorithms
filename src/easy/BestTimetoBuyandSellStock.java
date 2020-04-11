/**
 * 
 */
package easy;

/**
 * @author wangxinyu
 *
 */
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
        int i, j, max=0, length=prices.length;
		for(i = 0; i < length; i++){
			for(j = i; j < length; j++){
				if(prices[j] - prices[i] > max) max = prices[j] - prices[i];
			}
		}
		return max;
    }
}
