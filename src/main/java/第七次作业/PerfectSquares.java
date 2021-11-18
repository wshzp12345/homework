package 第七次作业;

import java.util.Arrays;

public class PerfectSquares {
    class Solution {
        public int numSquares(int n) {
            // f[j]
            // 先找到 f[j] 需要的最小数量， f[j + i*i] = f[j] + 1
            // 循环推导每个 f[j] 的最小值：min f[j - i * i] , f[j]
            // f[1] = 5(i = 1,j = 1,amoun t= 5), f[4] = f[5 - 4] + 1 (i = 2, j = 4, amount = 5)

            int f [] = new int[n+1];


            Arrays.fill(f, Integer.MAX_VALUE);
            f[0] = 0;

            for( int i = 1; i * i <= n; i++) {
                for(int j = i * i; j <= n; j++) {
                    f[j] = Math.min(f[j - (i * i)] + 1 , f[j]);
                }
            }

            return f[n];
        }
    }
}
