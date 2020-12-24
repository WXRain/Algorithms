package hard;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Candy135 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        int length = ratings.length;
        int[] nums = new int[length];
        Arrays.fill(nums, 1);
        int res = 0;
        boolean x = true;
        while (x) {
            x = false;
            for (int i = 1; i < length; i++) {
                if (ratings[i] > ratings[i - 1] && nums[i] <= nums[i - 1]) {
                    nums[i] = nums[i - 1] + 1;
                    x = true;
                }
                if (ratings[i] < ratings[i - 1] && nums[i] >= nums[i - 1]) {
                    nums[i - 1] = nums[i] + 1;
                    x = true;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            res += nums[i];
        }
        return res;
    }
}
