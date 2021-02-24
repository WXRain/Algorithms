package medium;

import java.util.Arrays;

/**
 *
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int[] chars = new int[128];
        Arrays.fill(chars, -1);
        int length = s.length();
        int res = 1;
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (chars[s.charAt(i)] < 0) {
                chars[s.charAt(i)] = i;
                continue;
            }
            int index = chars[s.charAt(i)];
            res = Math.max(res, i - start);
            start = index + 1;
            for (int j = 0; j < 128; j++) {
                if (chars[j] <= index) {
                    chars[j] = -1;
                }
            }
            chars[s.charAt(i)] = i;
        }
        int last = 0;
        for (int i = 0; i < 128; i++) {
            last = (chars[i] < 0 ? last : last + 1);
        }
        return Math.max(res, last);
    }
    public static void main(String[] args){
        new Offer48().lengthOfLongestSubstring("ohomm");
    }
}
