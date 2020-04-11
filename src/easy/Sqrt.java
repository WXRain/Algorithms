/**
 * 
 */
package easy;

/**
 * @author wangxinyu
 *
 */
public class Sqrt {
	public static int mySqrt(int x) {
		if(x==0) return 0;
		if(x == 4) return 2;
		int i = 1;
        for(i = 1; i <= x/2+1; i++){
        		if((long)(i-1)*(i-1) <= x && (long)i*i>x) return i-1;
        }
        return 1;
    }
	public static void main(String[] args) {
		System.out.println(mySqrt(25));
		//int i = 46341;
		//System.out.println((long)i*i > 2147395600);
	}
}
