/**
 * 
 */
package sort;

/**
 * @author wangxinyu
 *
 */
public class Util {

	public static void outArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] random(int[] array){
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random() * 100);
		}
		return array;
	}
	
}
