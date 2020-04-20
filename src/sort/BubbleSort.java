/**
 * 
 */
package sort;

/**
 * @author rain
 * 冒泡排序
 * 平均时间复杂度：O(n^2)
 * 最佳情况：O(n)
 * 最坏情况：O(n^2)
 *
 */
public class BubbleSort {

	public static int[] bubbleSort(int[] array){
		if(array.length == 0) return array;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length - 1 - i; j++){
				if(array[j+1] < array[j]){
					int num = array[j];
					array[j] = array[j+1];
					array[j+1] = num;
				}
			}
		}
		return array;
	}
	
	public static void main(String args[]){
		int[] array = new int[100];
		Util.random(array);
		Util.outArray(array);
		Util.outArray(bubbleSort(array));
	}
}
