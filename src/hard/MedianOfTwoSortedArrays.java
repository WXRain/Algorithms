/**
 * 
 */
package hard;

/**
 * @author wangxinyu
 *
 */
public class MedianOfTwoSortedArrays {
	/**
	 * 找到第k小的数
	 * @param nums1 第一个数组
	 * @param m 第一个数组的长度
	 * @param nums2 第二个数组
	 * @param n 第二个数组的长度
	 * @param k 要找到的第k小的数
	 * @return 第k小的数
	 */
	public static double findKth(int[] nums1, int m, int[] nums2, int n, int k){
		//始终保证第一个数组长度小于第二个数组长度
		if(m > n) return findKth(nums2, n, nums1, m, k);
		//如果第一个数组长度为0，直接返回第二个数组的第k位
		if(m == 0) return nums2[k-1];
		//如果是找第一小的数，直接比较两个数组的第一个数字，返回最小的那个
		if(k == 1) return Math.min(nums1[0], nums2[0]);
		//将k分成两部分
		int pa = Math.min(m, k/2), pb = k - pa;
		if(nums1[pa-1] < nums2[pb-1]){
			return findKth(spiltArray(nums1, pa), m-pa, nums2, n, k - pa);
		}else if(nums1[pa-1] > nums2[pb-1]){
			return findKth(nums1, m, spiltArray(nums2, pb), n - pb, k - pb);
		}else{
			return nums1[pa-1];
		}
	}
	/**
	 * 按给定的开始位置分割数组（整数数组），默认分割到数组末尾
	 * @param array 要分割的数组
	 * @param beginLocation 分割的开始位置
	 * @return 分割后的后半段
	 */
	public static int[] spiltArray(int[] array, int beginLocation){
		int[] result = new int[array.length - beginLocation];
		for(int i = beginLocation; i < array.length; i++){
			result[i - beginLocation] = array[i];
		}
		return result;
	}
	/**
	 * 给定两个按从小到大排序的数组，找到两个数组合并后的中位数
	 * @param nums1 第一个数组
	 * @param nums2 第二个数组
	 * @return 中位数
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if((m+n) % 2 == 1) return findKth(nums1, m, nums2, n, (m+n)/2+1);
		else return (findKth(nums1, m, nums2, n, (m+n)/2) + findKth(nums1, m, nums2, n, (m+n)/2 + 1))/2;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,3};
		int[] nums2 = {2,4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
