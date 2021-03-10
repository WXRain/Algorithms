package medium;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 *@author rain
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
    		if(s == null || s.length() == 0) return 0;
    		if(s.length() == 1) return 1;
    		Map<Character, Integer> map = new HashMap<Character, Integer>();
    		int i = 0, num = 0, max = 0;
    		for(i = 0; i < s.length(); i++){
    			char ch = s.charAt(i);
    			if(!map.containsKey(ch)){
    				map.put(ch, i);
    				num++;
    			}else{
    				i = map.get(s.charAt(i));
    				if(num > max) max = num;
    				num = 0;
    				map.clear();
    			}
    		}
    		if(num > max) max = num;
    		return max;
    }
}
