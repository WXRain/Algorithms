package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2] 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [4,9] 说明：
 * 
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 我们可以不考虑输出结果的顺序。 进阶:
 * 
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？ 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author rain
 */
public class Intersect350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0)
			return new int[0];
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for (int i : nums1) {
			list.add(i);
		}
		for (int i : nums2) {
			if (list.remove((Integer) i)) {
				result.add(i);
			}
		}
		int[] r = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			r[i] = result.get(i);
		}
		return r;
	}
}
