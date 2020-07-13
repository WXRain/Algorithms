package medium;

import java.util.Collections;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 
 *  
 * 
 * 例如，给定三角形：
 * 
 * [ [2], [3,4], [6,5,7], [4,1,8,3] ] 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author rain
 */
public class MinimumTotal120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() < 1)
			return 0;
		if (triangle.size() == 1)
			return triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (j == 0) {
					triangle.get(i).set(j, triangle.get(i - 1).get(j) + triangle.get(i).get(j));
				} else if (j == triangle.get(i).size() - 1) {
					triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j));
				} else {
					int min = Math.min(triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1),
							triangle.get(i).get(j) + triangle.get(i - 1).get(j));
					triangle.get(i).set(j, min);
				}
			}
		}
		return Collections.min(triangle.get(triangle.size() - 1));
	}
}
