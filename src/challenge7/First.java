package challenge7;

import java.util.Arrays;

public class First {
    public int maximumWealth(int[][] accounts) {
        int[] total = new int[accounts.length];
        for(int i = 0; i < accounts.length; i++){
            total[i] = 0;
            for(int j = 0; j < accounts[i].length; j++){
                total[i] += accounts[i][j];
            }
        }
        Arrays.sort(total);
        return total[total.length - 1];
    }
}
