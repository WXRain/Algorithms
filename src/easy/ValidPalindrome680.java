package easy;
/**
 * 
 *@author rain
								给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
								
								示例 1:
								
								输入: "aba"
								输出: True
								示例 2:
								
								输入: "abca"
								输出: True
								解释: 你可以删除c字符。
								注意:
								
								字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
								
								来源：力扣（LeetCode）
								链接：https://leetcode-cn.com/problems/valid-palindrome-ii
								著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidPalindrome680 {
	public boolean validPalindrome(String s) {
		if(s == null || s.length() == 0) return true;
		return valid(s, 0, s.length()-1, 0);
    }
	private boolean valid(String s, int low, int high, int delete){
		if(low > high) return false;
		if(low == high) return true;
		while(low < high){
			if(s.charAt(low) == s.charAt(high)){
				low++;
				high--;
			}else{
				if(delete == 0){
					return valid(s, low+1, high, delete+1) || valid(s, low, high-1, delete+1);
				}else return false;
			}
		}
		return true;
	}
}
