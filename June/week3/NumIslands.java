package June.week3;

/**
 * Created by Alex_Xie on 13/06/2017.
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011

 https://leetcode.com/problems/number-of-islands/#/description
 */
public class NumIslands {
    private int row = 0;
    private int col = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        row = grid.length;
        col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    // TODO: Why we call it DFS instead of BFS ??
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i, j -1);
        DFSMarking(grid, i, j + 1);
    }

}
