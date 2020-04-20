/**
 * 
 */
package easy;

/**
 * @author rain
 *
 */
public class MaxSubArray {
	public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int sum = nums[0];
        dp[0] = nums[0];
        int i = 1;
        for(i = 1; i < nums.length; i++){
        		dp[i] = nums[i] > (dp[i-1] + nums[i]) ? nums[i] : (dp[i-1] + nums[i]);
        		sum = sum > dp[i] ? sum : dp[i];
        }
        return sum;
    } 
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}
