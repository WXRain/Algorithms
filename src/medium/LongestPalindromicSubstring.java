/**
 * 
 */
package medium;

/**
 * @author rain
 *
 */

/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"

 */
public class LongestPalindromicSubstring {
	
	public static String longestPalindrome(String s){
		if(s == null || s.length() == 0) return "";
		//保存当前最大长度的回文字符串起始位置和结束位置
		int end = 0, start = 0;
		for(int i = 0; i < s.length(); i++){
			int len1 = expand(s, i, i);
			int len2 = expand(s, i, i+1);
			int len = Math.max(len1, len2);
			if(len > end - start){
				start = i - (len-1)/2;
				end = i + (len)/2;
			}
		}
		return s.substring(start, end+1);
	}
	
	public static int expand(String s, int left, int right){
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}
		return right - left - 1;
	}
	
	public static void main(String[] args) {
		String s = "dabcbaaaaaa";
		System.out.println(longestPalindrome(s));
	}
}

