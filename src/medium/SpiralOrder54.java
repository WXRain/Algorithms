package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int i = 0, j = 0;
        while (i >= up && i <= down && j >= left && j <= right && left <= right && up <= down) {
            while (j <= right && left <= right && up <= down) {
                res.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            up++;
            while (i <= down && left <= right && up <= down) {
                res.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            right--;
            while (j >= left && left <= right && up <= down) {
                res.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            down--;
            while (i >= up && left <= right && up <= down) {
                res.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        new SpiralOrder54().spiralOrder(nums);
    }
}
