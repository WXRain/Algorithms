/**
 * 
 */
package easy;

/**
 * @author wangxinyu
 *
 */
public class Beer {


public static char getRandomChar() {
        return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e01 + 1)));
    }


	public static void main(String[] args) {
//		int beer = 100;
//		int bottole = beer;
//		while(bottole >= 3){
//			beer += bottole/3;
//			bottole = bottole - (bottole/3)*3 + (bottole/3);
//		}
//		System.out.println(beer + " " + bottole);
		System.out.println(getRandomChar());
	}
	
}
