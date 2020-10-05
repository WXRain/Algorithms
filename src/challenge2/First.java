package challenge2;

import java.util.Arrays;

public class First {
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        for (int i = 0; i <= max; i++){
            int num = 0;
            for(int j : nums){
                if(j >= i) num++;
            }
            if(num == i) return num;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {0, 4, 3, 0, 4};
        System.out.println(specialArray(nums));
    }
}
