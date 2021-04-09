/**
 * 
 */
package easy;

/**
 * @author rain
 *
 */
public class MySqrt69 {
	public static int mySqrt(int x) {
		if(x == 0) return 0;
		if(x == 1) return 1;
		int left = 0, right = x;
		int ans = -1;
		while(left <= right){
			int mid = (left + right) / 2;
			if(mid * mid == x){
				return mid;
			}
			if((long)mid * mid < x){
				ans = mid;
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return ans;
    }
	public static void main(String[] args) {
		System.out.println(mySqrt(2147483647));
		//int i = 46341;
		//System.out.println((long)i*i > 2147395600);
	}
}
