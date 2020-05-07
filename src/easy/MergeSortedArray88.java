/**
 * 
 */
package easy;

/**
 * @author rain
 *
 */
public class MergeSortedArray88 {
	/**
	 * 
	 * @param nums1  第一个数组
	 * @param m	  	 第一个数组的初始化元素个数
	 * @param nums2	 第二个数组
	 * @param n	     第二个数组的初始化元素个数
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, min = 0;
        for(j = 0; j < n; j++){
        		nums1[m+j] = nums2[j];
        }
        for(i = 0; i < m+n; i++){
        		min = i;
        		for(j = i; j < m+n; j++){
        			if(nums1[min] > nums1[j]){
        				min = j;
        			}
        		}
        		int mid = nums1[min];
        		nums1[min] = nums1[i];
        		nums1[i] = mid;
        }
    }
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {4,5,6};
		merge(nums1, 3, nums2, 3);
		for(int i = 0; i < 6; i++){
			System.out.println(nums1[i]);
		}
	}
}
