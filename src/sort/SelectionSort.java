/**
 * 
 */
package sort;

/**
 * @author wangxinyu
 * 选择排序
 * 平均时间复杂度：O(n^2)
 * 最佳情况：O(n^2)
 * 最坏情况：O(n^2)
 * 非常稳定
 */
public class SelectionSort {
	
	public static int[] selectionSort(int[] array){
		if(array.length == 0) return array;
		for(int i = 0; i < array.length; i++){
			int min = i;
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[min]){
					min = j;
				}
			}
			int num = array[i];
			array[i] = array[min];
			array[min] = num;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = new int[100];
		Util.random(array);
		Util.outArray(array);
		Util.outArray(selectionSort(array));
	}
	
}
