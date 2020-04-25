package medium;
/**
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.LinkedList;
import java.util.List;

import util.Utils;

public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
    		if(nums == null || nums.length == 0) return new LinkedList<List<Integer>>();
    		return calculate(nums, 0, nums.length);
    }
    
    public static List<List<Integer>> calculate(int[] nums, int start, int end){
    		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> list = new LinkedList<Integer>();
		int i, j;
    		if(end - start == 1){
			list.add(nums[start]);
			result.add(list);
			return result;
		}
    		List<List<Integer>> temp = calculate(nums, start + 1, end);
    		for(i = 0; i < temp.size(); i++){
    			for(j = 0; j <= temp.get(i).size(); j++){
    				List<Integer> tempList = new LinkedList<Integer>();
    				tempList.addAll(temp.get(i));
    				tempList.add(j, nums[start]);
    				result.add(tempList);
    			}
    		}
    		return result;
    }
    public static void main(String[] args) {
		int[] nums = Utils.string2intarray("[1,2,3]");
		Utils.printLists(permute(nums));
	}
}
