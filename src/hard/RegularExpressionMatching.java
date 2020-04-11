/**
 * 
 */
package hard;

/**
 * @author wangxinyu
 *
 */

/*
 Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

 */

public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		if(s.equals(p)) return true;
        int i = 0, j = 0, x = 0;
        for(i = 0; i < s.length(); i++){
        		char a = s.charAt(i);
        		if(j >= p.length()) return false;
        		char b = p.charAt(j);
        		if(a == b) j++;
        		else if(b == '.') j++;
        		else if(b == '*'){
        			if(a == p.charAt(x) || p.charAt(x) == '.') ;
        			else if(j + 1 < p.length() && (a == p.charAt(j + 1) || p.charAt(j+1) == '.')) j += 2;
        			else return false;
        		}else if(j + 2 < p.length() && p.charAt(j+1) == '*' && a == p.charAt(j+2)){
        			j += 3;
        		}else{
        			return false;
        		}
        		
        		x = j - 1;
        }
        if(j < p.length()) return false;
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a*"));
	}
}
















