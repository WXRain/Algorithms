package medium;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateMatrix59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int i = 0, j = 0;
        int x = 1;
        while (i >= up && i <= down && j >= left && j <= right && up <= down && left <= right) {
            while (j <= right) {
                res[i][j] = x;
                x++;
                j++;
            }
            j--;
            i++;
            up++;
            while (i <= down) {
                res[i][j] = x;
                x++;
                i++;
            }
            i--;
            j--;
            right--;
            while (j >= left) {
                res[i][j] = x;
                x++;
                j--;
            }
            j++;
            i--;
            down--;
            while (i >= up) {
                res[i][j] = x;
                x++;
                i--;
            }
            i++;
            j++;
            left++;
        }
        return res;
    }
}
