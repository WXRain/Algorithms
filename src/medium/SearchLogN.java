package medium;
/**
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import util.Utils;

public class SearchLogN {
	public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1 && nums[0] != target) return -1;
        int start = 0, end = nums.length - 1;
        int mid;
        while(start <= end){
        		mid = (start + end) / 2;
        		if(nums[mid] == target) return mid;
        		if(nums[start] <= nums[mid]){//左边有序
        			if(nums[start] <= target && nums[mid] >= target){//target在左边
        				end = mid;
        			}else{
        				start = mid + 1;
        			}
        		}else if(nums[mid+1] <= nums[end]){//右边有序
        			if(nums[mid + 1] <= target && nums[end] >= target){//target在右边
        				start = mid+1;
        			}else{
        				end = mid;
        			}
        		}
        		if(start < 0 || end >= nums.length) return -1;
        }
        return -1;
    }
	public static void main(String[] args) {
		int[] nums = Utils.string2intarray("[1,3]");
		System.out.println(search(nums, 3));
	}
}
