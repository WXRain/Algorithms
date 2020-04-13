/**
 * 
 */
package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import util.Utils;

/**
 * @author wangxinyu
 *
 */
public class Sum3 {
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
        int i;
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        for(i = 0; i < nums.length; i++){
        		twoSum(nums, 0-nums[i], i, result);
        }
        List<List<Integer>> list = new LinkedList<List<Integer>>(result);
        return list;
        
    }
	public static void twoSum(int[] nums, int sum, int m, Set<List<Integer>> result){
		List<Integer> list = new LinkedList<Integer>();
		int i=0, j=nums.length-1;
		while(i < j){
			if(i == m) {
				i++;continue;
			}
			if(j == m){
				j--;continue;
			}
			if(nums[i] + nums[j] == sum) {
				list.add(nums[i]);
				list.add(nums[j]);
				list.add(nums[m]);
				Collections.sort(list);
				result.add(list);
				list = new LinkedList<Integer>();
				i++;j--;
			}else if(nums[i] + nums[j] > sum){
				j--;
			}else{
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = Utils.string2intarray("[-1,0,1, 2, -1, -4]");
		List<List<Integer>> result = threeSum(nums);
		Utils.printLists(result);
	}
}
