package medium;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和
 * 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 *  
 * 
 * 示例：
 * 
 * 输入：nums = [-1,2,1,-4], target = 1 输出：2 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)
 * 。  
 * 
 * 提示：
 * 
 * 3 <= nums.length <= 10^3 -10^3 <= nums[i] <= 10^3 -10^4 <= target <= 10^4
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author rain
 */
public class TreeSumCloset16 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int i = 0;
		while (true) {
			if (threeSum(nums, target - i))
				return target - i;
			if (threeSum(nums, target + i))
				return target + i;
			i++;
		}

	}

	public boolean threeSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (twoSum(nums, target - nums[i], i))
				return true;
		}
		return false;
	}

	public boolean twoSum(int[] nums, int target, int now) {
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			if (nums[i] + nums[j] == target && i != now && j != now) {
				return true;
			} else if (nums[i] + nums[j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}
