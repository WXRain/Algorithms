package challenge3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Second {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < l.length; i++){
            int[] temp = new int[r[i]-l[i]+1];
            for(int j = l[i]; j <= r[i]; j++){
                temp[j-l[i]] = nums[j];
            }
            Arrays.sort(temp);
            if(temp.length <= 2) {
                res.add(true);
                continue;
            }
            int sub = temp[1] - temp[0];
            boolean b = true;
            for(int k = 1; k < temp.length; k++){
                if(temp[k] - temp[k-1] == sub);
                else{
                    b = false;
                    break;
                }
            }
            res.add(b);
        }
        return res;
    }
}
