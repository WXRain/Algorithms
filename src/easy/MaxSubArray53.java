package easy;
/**
 * 
 *@author rain
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray53 {
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int i, max = nums[0];
        for(i = 1; i < nums.length; i++){
        		nums[i] = Math.max(nums[i-1] + nums[i], nums[i]);
        		max = Math.max(nums[i], max);
        }
        return max;
    }
}
