package hard;

import java.util.*;

/**
 *给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *  
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 *
 * 提示：
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveNQueens51 {

    private Set<Integer> main;
    private Set<Integer> col;
    private Set<Integer> sub;
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) return res;

        col = new HashSet<>();
        main = new HashSet<>();
        sub = new HashSet<>();

        Deque<Integer> path = new ArrayDeque<>();

        dfs(0, path);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            List<String> board = convert2Board(path, n);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !main.contains(row + i) && !sub.contains(row - i)) {
                path.addLast(i);
                col.add(i);
                main.add(row + i);
                sub.add(row - i);

                dfs(row + 1, path);

                col.remove(i);
                main.remove(row + i);
                sub.remove(row - i);
                path.removeLast();
            }
        }
    }

    private List<String> convert2Board(Deque<Integer> path, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < Math.max(0, n); i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }
}
