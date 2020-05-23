package hard;
/**
 * 
 *@author rain
						给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
						
						示例：
						
						输入: S = "ADOBECODEBANC", T = "ABC"
						输出: "BANC"
						说明：
						
						如果 S 中不存这样的子串，则返回空字符串 ""。
						如果 S 中存在这样的子串，我们保证它是唯一的答案。
						
						来源：力扣（LeetCode）
						链接：https://leetcode-cn.com/problems/minimum-window-substring
						著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow76 {
	public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        int[] winFreq = new int [128];
        int[] tFreq = new int [128];
        
        for(char c : tArray){
        		tFreq[c]++;
        }
        
        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;
        
        int left = 0;
        int right = 0;
        //[left, right)
        while(right < sLen){
        		if(tFreq[sArray[right]] == 0){
        			right++;
        			continue;
        		}
        		if(winFreq[sArray[right]] < tFreq[sArray[right]])
        			distance++;
        		winFreq[sArray[right]]++;
        		right++;
        		
        		while(distance == tLen){
        			if(right - left < minLen){
        				minLen = right - left;
        				begin = left;
        			}
        			
        			if(tFreq[sArray[left]] == 0){
        				left++;
        				continue;
        			}
        			if(winFreq[sArray[left]] == tFreq[sArray[left]]){
        				distance--;
        			}
        			winFreq[sArray[left]]--;
        			left++;
        		}
        }
        if(minLen == sLen + 1) return "";
        else return s.substring(begin, begin + minLen);
    }
}
