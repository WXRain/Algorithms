package medium;

import java.util.Stack;

/**
 *给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseParentheses1190 {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        char[] ss = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : ss) {
            if (c != ')') {
                StringBuilder temp = new StringBuilder(c + "");
                stack.push(temp);
                continue;
            }
            StringBuilder temp = new StringBuilder();
            while (!stack.isEmpty() && !stack.peek().toString().equals("(")) {
                StringBuilder sb = stack.pop().reverse();
                temp.append(sb);
            }
            if (!stack.isEmpty() && stack.peek().toString().equals("(")) {
                stack.pop();
            }
            stack.push(temp);
        }
        while (!stack.isEmpty()) {
            StringBuilder sb = stack.pop().reverse();
            result.append(sb);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        new ReverseParentheses1190().reverseParentheses("(abcd)");
    }
}
