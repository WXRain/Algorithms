/**
 * 
 */
package medium;

import util.Utils;

/**
 * @author wangxinyu
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 *
 */
public class FindFirstandLastPositionofElementinSortedArray {
	public static int[] searchRange(int[] nums, int target) {
		int[] result = {-1, -1};
		if(nums == null || nums.length == 0) return result;
        return search(0, nums.length-1, nums, target, result);
    }
	public static int[] search(int start, int end, int[] nums, int target, int[] result){
		if(start > end || start < 0 || end >= nums.length){
			result[0] = -1;
			result[1] = -1;
			return result;
		}
		if(start == end){
			if(nums[start] == target){
				result[0] = start;
				result[1] = start;
				return result;
			}else{
				result[0] = -1;
				result[1] = -1;
				return result;
			}	
		}
		int mid = (start + end) / 2;
		if(nums[mid] == target){
			int temp = mid;
			while(mid >= 0 && nums[mid] == target) mid--;
			result[0] = mid + 1;
			while(temp < nums.length && nums[temp] == target) temp++;
			temp--;
			result[1] = temp;
		}
		else if(nums[mid] > target){
			result = search(start, mid-1, nums, target, result);
		}else{
			result = search(mid+1, end, nums, target, result);
		}
		return result;
	}
	public static void main(String[] args) {
		int[] nums = Utils.string2intarray("[2,2]");
		Utils.printIntArray(searchRange(nums, 2));
	}
}
