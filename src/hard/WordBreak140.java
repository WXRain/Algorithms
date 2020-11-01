package hard;

import java.util.*;

public class WordBreak140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int right = 1; right <= len; right++){
            for(int left = right-1; left >= 0; left--){
                if(set.contains(s.substring(left, right)) && dp[left]){
                    dp[right] = true;
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if(dp[len]){
            Deque<String> path = new ArrayDeque<>();
            dfs(s, len, set, dp, path, res);
        }
        return res;
    }

    private void dfs(String s, int len, Set<String> set, boolean[] dp, Deque<String> path, List<String> res) {
        if(len == 0){
            res.add(String.join(" ", path));
            return;
        }
        for(int i = len-1; i >= 0; i--){
            String suffix = s.substring(i, len);
            if(set.contains(suffix) && dp[i]){
                path.addFirst(suffix);
                dfs(s, i, set, dp, path, res);
                path.removeFirst();
            }
        }
    }
}
