package easy;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IslandPerimeter463 {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if (row == 0 || col == 0) return 0;
        int length = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i - 1 < 0) {
                    if (grid[i][j] == 1) length++;
                } else {
                    if (grid[i - 1][j] == 0 && grid[i][j] == 1) length++;
                }
                if (i + 1 >= row) {
                    if (grid[i][j] == 1) length++;
                } else {
                    if (grid[i + 1][j] == 0 && grid[i][j] == 1) length++;
                }
                if (j - 1 < 0) {
                    if (grid[i][j] == 1) length++;
                } else {
                    if (grid[i][j - 1] == 0 && grid[i][j] == 1) length++;
                }
                if (j + 1 >= col) {
                    if (grid[i][j] == 1) length++;
                } else {
                    if (grid[i][j + 1] == 0 && grid[i][j] == 1) length++;
                }
            }
        }
        return length;
    }
}
