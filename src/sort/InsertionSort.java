/**
 * 
 */
package sort;

/**
 * @author wangxinyu
 * 插入排序
 * 平均时间复杂度：O(n^2)
 * 最佳情况：O(n)
 * 最坏情况：O(n^2)
 */
public class InsertionSort {

	public static int[] insertionSort(int[] array){
		if(array.length == 0) return array;
		int current;
		for(int i = 0; i < array.length - 1; i++){
			current = array[i + 1];
			int preIndex = i;
			while(preIndex >= 0 && current < array[preIndex]){
				array[preIndex + 1] = array[preIndex];
				preIndex--;
			}
			array[preIndex + 1] = current;
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = new int[100];
		Util.random(array);
		Util.outArray(array);
		Util.outArray(insertionSort(array));
	}
}
