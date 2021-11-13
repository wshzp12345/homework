package 第六次作业;

import java.util.List;

public class Triangle {
    class Solution {
        public int minimumTotal(List<List<Integer>> t) {
            int n = t.size();

            int f[][] = new int[n+1][n+1];



            for(int i = n-1;i >= 0; i--) {
                List<Integer> curRow = t.get(i);
                for(int j = 0; j <curRow.size(); j ++) {
                    f[i][j] = Math.min(f[i+1][j], f[i+1][j+1]) + curRow.get(j);
                }

            }
            return f[0][0];
        }
    }
}
