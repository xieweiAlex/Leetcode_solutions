package June.week5;

/**
 * Created by Alex_Xie on 29/06/2017.
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }

        return map[m-1][n-1];
    }
}
