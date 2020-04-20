/**
 * 
 */
package easy;

/**
 * @author rain
 *
 */
public class ClimbStairs {
	public static int climbStairs(int n) {
		int num1 = 1, num2 = 2;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int i;
        for(i = 1; i < n/2; i+=1){
        		num1 = num1 + num2;
        		num2 = num1 + num2;
        }
        if(i*2 == n) return num2;
        return num1+num2;
    }
	public static void main(String[] args) {
		System.out.println(climbStairs(45));
	}
}
