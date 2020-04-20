/**
 * 
 */
package medium;

/**
 * @author rain
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

示例 1:

输入:
11110
11010
11000
00000
输出: 1
示例 2:

输入:
11000
11000
00100
00011
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfIsland {
	/**
思路：遍历岛这个二维数组，如果当前数为1，则进入find函数并将岛个数+1
find函数：其实就是一个递归标注的过程，它会将所有相连的1都标注成2。为什么要标注？
这样就避免了遍历过程中的重复计数的情况，一个岛所有的1都变成了2后，遍历的时候就不会重复遍历了
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		int i, j, num = 0;
		for(i = 0; i < grid.length; i++){
			for(j = 0; j < grid[i].length; j++){
				if(grid[i][j] == '1'){
					find(grid, i, j);
					num++;
				}
			}
		}
		return num;
    }
	public void find(char[][] grid, int i, int j){
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') return;
		grid[i][j] = '2';
		find(grid, i-1, j);
		find(grid, i+1, j);
		find(grid, i, j-1);
		find(grid, i, j+1);
	}
}
