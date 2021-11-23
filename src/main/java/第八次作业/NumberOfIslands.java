package 第八次作业;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            fa = new int[m*n + 1];
            int outside = m*n;
            for(int i = 0; i <= m*n; i ++) {
                fa[i] = i;
            }

            for(int i = 0; i < m; i ++) {
                for(int j = 0; j < n; j ++) {
                    if(grid[i][j] == '0') {
                        unionSet(num(i,j),outside);
                        continue;
                    }
                    for(int v = 0; v < 2; v ++) {
                        int nx = i + dx[v];
                        int ny = j + dy[v];
                        if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                            continue;
                        }else {
                            if(grid[nx][ny] == '1')
                                unionSet(num(i,j),num(nx,ny));
                        }

                    }
                }
            }

            set = new HashSet<>();
            int res = 0;
            outside = find(outside);
            for(int i = 0; i <= m*n; i ++) {
                if(outside == fa[i]) continue;
                if(!set.contains(find(fa[i]))) {
                    res ++;
                    set.add(find(fa[i]));
                }
            }

            return res;
        }

        private int [] fa ;
        int m;
        int n;
        int dx[] = {0,1};
        int dy[] = {1,0};
        private Set<Integer> set;
        private int num(int x, int y) {
            return x * n + y;
        }

        private int find(int x) {
            if(x == fa[x]) return x;
            return fa[x] = find(fa[x]);
        }

        private void unionSet(int x, int y) {
            x = find(x);
            y = find(y);
            if(x != y) fa[x] = y;
        }
    }
}
