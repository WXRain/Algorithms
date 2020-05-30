package hard;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 
 *@author rain
							 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
							
							求在该柱状图中，能够勾勒出来的矩形的最大面积。
							
							 
							
							
							
							以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
							
							 
							
							
							
							图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
							
							来源：力扣（LeetCode）
							链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
							著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
							 */
public class LargestRectangleArea84 {
	public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int area = 0;
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];
                int width  = i - stack.peekLast() - 1;
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        return area;
    }
}
