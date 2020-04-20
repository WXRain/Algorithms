/**
 * 
 */
package medium;

/**
 * @author rain
 * 1. 对于负数的考虑　
 *
 */
public class DivideTwoIntegers {
	public static void main(String[] args) {
		System.out.println(divide(-2147483648,-1));
	}
	public static int divide(int dividend, int divisor) {
		boolean flag = false;
		
		if(dividend < 0){
			dividend = dividend > Integer.MIN_VALUE ? dividend : -Integer.MAX_VALUE;
			flag = !flag;
			dividend = -dividend;
		}else{
			dividend = dividend < Integer.MAX_VALUE ? dividend : Integer.MAX_VALUE;
		}
		if(divisor < 0){
			divisor = divisor > Integer.MIN_VALUE ? divisor : -Integer.MAX_VALUE;
			flag = !flag;
			divisor = -divisor;
		}else{
			divisor = divisor < Integer.MAX_VALUE ? divisor : Integer.MAX_VALUE;
		}
		
		int res = 0;
		while(dividend >= divisor){
			int t = divisor, p = 1;
			while(dividend > (t << 1)){
				t <<= 1;
				p <<= 1;
			}
			res += p;
			dividend -= t;
		}
        return flag ? -res : res; 
    }
	
}
