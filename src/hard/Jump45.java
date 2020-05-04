package hard;
/**
 * 
 *@author rain
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Jump45 {
	//寻找的并不是在范围内最大值，而是下标与数组在该下标的值的和 与 之前能到的的最大值 两者中取最大值
	public int jump(int[] nums) {
		if(nums == null || nums.length == 0 || nums.length == 1) return 0;
		int step = 0;//需要多少步
		int reach = 0;//经过step步之后能到达的最远距离
		int nextreach = nums[0];//下一步能到达的最远距离
		for(int i = 0; i < nums.length; i++){
			nextreach = Math.max(nextreach, i+nums[i]);
			if(nextreach > nums.length) return (step+1);
			if(i == reach){
				step++;
				reach = nextreach;
			}
		}
		return step;
    }
}
