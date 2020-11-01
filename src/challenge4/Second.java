package challenge4;

import java.util.Arrays;

public class Second {
    public static int countVowelStrings(int n) {
        if (n == 1) return 5;
        int[] arr = {1, 1, 1, 1, 1};
        int[] temp = new int[5];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j];
            }
            temp[0] = sum;
            for (int j = 1; j < temp.length; j++) {
                temp[j] = sum - arr[j - 1];
                sum -= arr[j - 1];
            }
            arr = Arrays.copyOf(temp, temp.length);
        }
        return arr[0];
    }

    public static void main(String[] args) {
        countVowelStrings(2);
    }
}
