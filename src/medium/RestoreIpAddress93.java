package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddress93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        List<String> temp = new LinkedList<>();
        helper(result, temp, s);
        return result;
    }

    private void helper(List<String> result, List<String> temp, String next) {
        if (temp.size() > 4) return;
        if (temp.size() == 4 && next.length() == 0) {
            String ip = temp.get(0) + "." + temp.get(1) + "." + temp.get(2) + "." + temp.get(3);
            result.add(ip);
            return;
        }
        for (int i = 0; i < next.length(); i++) {
            String s = next.substring(0, i + 1);
            if (s.length() > 1 && s.charAt(0) == '0') continue;
            if (s.length() > 3) continue;
            if (s.length() == 3 && "255".compareTo(s) < 0) continue;
            temp.add(s);
            helper(result, temp, next.substring(i + 1));
            temp.remove(temp.size() - 1);
        }
    }

}
