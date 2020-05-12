/**
 * 
 */
package easy;

import java.util.Arrays;

import util.Utils;

/**
 * @author rain
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 *
 */
public class SingleNumber136 {
	public static int singleNumber(int[] nums) {
//		if(nums.length == 1) return nums[0];
//        Arrays.sort(nums);
//        if(nums[0] != nums[1] && nums[1] == nums[2]) return nums[0];
//        for(int i = 0; i < nums.length && i+1 < nums.length; i+=2){
//        		if(nums[i] == nums[i+1]) continue;
//        		else return nums[i];
//        }
//        return nums[nums.length-1];
		int x = 0;
        //利用异或实现功能
        for (int i : nums) {
            x = x ^ i;
        }
        
        return x;
    }
	public static void main(String[] args) {
		int[] nums = Utils.string2intarray("[4,1,2,1,2]");
		System.out.println(singleNumber(nums));
	}
}
