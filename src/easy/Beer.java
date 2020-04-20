/**
 * 
 */
package easy;

/**
 * @author rain
 *
 */
public class Beer {
	public static void main(String[] args) {
		int beer = 100;
		int bottole = beer;
		while(bottole >= 3){
			beer += bottole/3;
			bottole = bottole - (bottole/3)*3 + (bottole/3);
		}
		System.out.println(beer + " " + bottole);
	}
	
}
