package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class PascalTriangle118 {
	public List<List<Integer>> generate(int numRows) {
		if(numRows == 0) return new LinkedList<List<Integer>>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        result.add(list);
        int i, j;
        for(i = 1; i < numRows; i++){
        		list = new LinkedList<Integer>();
        		list.add(1);
        		for(j=1; j < i; j++){
        			list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
        		}
        		list.add(1);
        		result.add(list);
        }
        return result;
    }
}
