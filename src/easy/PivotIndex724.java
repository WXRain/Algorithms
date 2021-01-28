package easy;

public class PivotIndex724 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res += nums[i];
        }
        if (res == 0) return 0;
        int left = nums[0];
        int right = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            right += nums[i];
        }
        int i = 1;
        for (i = 1; i < nums.length; i++) {
            right -= nums[i];
            if (left != right) {
                left += nums[i];
            } else {
                break;
            }
        }
        if (i == nums.length) return -1;
        else return i;
    }

    public static void main(String[] args) {
        PivotIndex724 pi = new PivotIndex724();
        int[] nums = {1, 7, 3, 6, 5, 6};
        pi.pivotIndex(nums);
    }
}
