package easy;

import java.util.LinkedList;
import java.util.List;

import util.Utils;
/**
 * 
 *@author rain

 */
public class FindDisappearedNumbers448 {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		//将数组对应下标的值设置为相反数，遍历一遍后，还为正数的位置就是缺少的数，因为数组中缺少将这些位置为负数的元素
		int i = 0;
		List<Integer> result = new LinkedList<Integer>();
		for(i = 0; i < nums.length; i++){
			nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
		}
		for(i = 0; i < nums.length; i++){
			if(nums[i] > 0) result.add(i+1);
		}
		return result;
    }
	public static void main(String[] args) {
		int[] nums = Utils.string2intarray("[4,3,2,7,8,2,3,1]");
		Utils.printList(findDisappearedNumbers(nums));
	}
}
