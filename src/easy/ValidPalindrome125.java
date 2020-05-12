/**
 * 
 */
package easy;

/**
 * @author rain
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 *
 */
public class ValidPalindrome125 {
	public static boolean isPalindrome(String s) {
		if(s == null || s.length() == 0 ) return true;
        s = s.toLowerCase();
        System.out.println(s);
        int i = 0, j = s.length() - 1;
        char a, b;
        while(i < j){
        		a = s.charAt(i);
        		b = s.charAt(j);
        		if(!check(a)) {
        			i++;
        			continue;
        		}
        		if(!check(b)){
        			j--;
        			continue;
        		}
        		if(a == b) {
        			i++;
        			j--;
        			continue;
        		}
        		else return false;
        }
        return true;
    }
	public static boolean check(char ch){
		if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch<= '9'))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		String s = "ab2a";
		System.out.println(isPalindrome(s));
	}
}
