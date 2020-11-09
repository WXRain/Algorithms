package challenge5;

import java.util.HashSet;
import java.util.Set;

public class Second {
    public static int minDeletions(String s) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++){
            chars[s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == 0) continue;
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
            }else{
                res++;
                chars[i]--;
                while(set.contains(chars[i]) && chars[i] != 0){
                    res++;
                    chars[i]--;
                }
                if(chars[i] != 0)
                    set.add(chars[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaabbbcc";
        minDeletions(s);
    }
}
