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
		return check(s, p, s.length()-1, p.length()-1);
    }
	public static boolean check(String s, String p, int i, int j){
		if(i == -1 && j == -1) return true;
		if(i != -1 && j == -1) return false;
		if(i == -1 && j != -1){
			if(p.charAt(j) == '*'){
				return check(s, p, i, j-2);
			}else return false;
		}else{
			if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') return check(s,p,i-1,j-1);
			else if(p.charAt(j) == '*'){
				if(p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.') return check(s,p,i-1,j) || check(s,p,i,j-2);
				else return check(s,p,i,j-2);
			}else return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
	}
}
















