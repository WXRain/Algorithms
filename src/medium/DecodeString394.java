package medium;

import java.util.Stack;
/**
 * 
 *@author rain
					给定一个经过编码的字符串，返回它解码后的字符串。
					
					编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
					
					你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
					
					此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
					
					示例:
					
					s = "3[a]2[bc]", 返回 "aaabcbc".
					s = "3[a2[c]]", 返回 "accaccacc".
					s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
					
					来源：力扣（LeetCode）
					链接：https://leetcode-cn.com/problems/decode-string
					著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeString394 {
	public String decodeString(String s) {
		Stack<Integer> nums = new Stack<Integer>();
		Stack<String> strs = new Stack<String>();
		int num = 0;
		String cur = "";
		int i;
		for(i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(ch >= '0' && ch <= '9'){
				num = num * 10 + ch - '0';
			}else if(ch == '['){
				nums.push(num);
				strs.push(cur);
				num = 0;
				cur = "";
			}else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
				cur += ch;
			}else if(ch == ']'){
				int k = nums.pop();
				String top = strs.pop();
				for(int j = 0; j < k; j++){
					top += cur;
				}
				cur = top;
			}
		}
		return cur;
    }
}
