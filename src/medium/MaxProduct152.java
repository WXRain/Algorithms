package medium;

public class MaxProduct152 {
	public int maxProduct(int[] nums) {
		if(nums.length == 1) return nums[0];
		int max = Integer.MIN_VALUE, imax = 1, imin = 1;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] < 0){
				int temp = imax;
				imax = imin;
				imin = temp;
			}
			imax = Math.max(nums[i]*imax, nums[i]);
			imin = Math.min(nums[i]*imin, nums[i]);
			
			max = Math.max(max, imax);
		}
		return max;
    }
}
