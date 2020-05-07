package easy;
/**
 * 
 *@author rain
给定一个整数，写一个函数来判断它是否是 3 的幂次方。

示例 1:

输入: 27
输出: true
示例 2:

输入: 0
输出: false
示例 3:

输入: 9
输出: true
示例 4:

输入: 45
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/power-of-three
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPowerOfThree326 {
	public static boolean isPowerOfThree(int n) {
		if(n < 1) return false;
		while(n != 1){
			if(n % 3 != 0) return false;
			n = n / 3;
		}
		return true;
    }
	/**
	 * 将int整数转换为三进制数，只要检查该字符串是否符合1开头后面跟任意个0即可，就可以确定是否是3的幂。
	 * public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
	 */
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(0));
	}
}
