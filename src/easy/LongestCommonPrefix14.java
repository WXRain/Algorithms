package easy;

/**
 * 
 * @author rain 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 *         如果不存在公共前缀，返回空字符串 ""。
 * 
 *         示例 1:
 * 
 *         输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 * 
 *         输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/longest-common-prefix
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix14 {
	public String longestCommonPrefix(String[] strs) {
		String result = "";

		if (strs == null || strs.length == 0)
			return result;

		if (strs.length == 1)
			return strs[0];

		int minLength = strs[0].length();

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < minLength)
				minLength = strs[i].length();
		}

		for (int j = 0; j < minLength; j++) {
			char ch = strs[0].charAt(j);
			for (int i = 0; i < strs.length; i++) {
				if (ch != strs[i].charAt(j))
					return result;
			}
			result += ch;
		}

		return result;
	}
}
