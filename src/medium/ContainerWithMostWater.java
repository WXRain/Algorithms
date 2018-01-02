/**
 * 
 */
package medium;

/**
 * @author wangxinyu
 *
 */
public class ContainerWithMostWater {

	public static int maxArea(int[] height) {
		int left = 0, right = height.length - 1, area = 0;
		do{
            //计算当前面积
			int now = ((right - left) * (height[left] < height[right] ? height[left] : height[right]));
            //比较当前面积和保存的最大面积，保存最大面积
			area = now > area ? now : area;
			if(height[left] < height[right]){
				left ++;
			}else{
				right --;
			}
		}while(left <= right);//当左右指针相遇结束
		return area;
    }
	
	public static void main(String[] args) {
		int[] height = {1,2,1};
		System.out.println(maxArea(height));
	}
}
