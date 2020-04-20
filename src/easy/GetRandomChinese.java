/**
 * 
 */
package easy;

/**
 * @author rain
 *
 */
public class GetRandomChinese {
	public static String getRandomChar() {
		String s = "";
		for(int i = 0; i < 10; i++){
			s = s +  (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e01 + 1))) + "";
		}
        return  s;
    }
	public static void main(String[] args) {
		System.out.println(getRandomChar());
	}
}
