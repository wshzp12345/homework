package 第七次作业;

import java.util.Arrays;

public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            // f[0] = 0
            // f[1] = max f[0] , 1 + nt[1]
            // f[2] = max f[1] , 2 + nt[2]

            // f[i] = max f[i - 1], i + nt[i]

            int n = nums.length;
            int nt [] = new int [n + 1];
            System.arraycopy(nums, 0, nt, 1, n);
            int f[] = new int [n + 1];
            Arrays.fill(f, Integer.MIN_VALUE);
            f[0] = 0;

            for(int i = 1; i <= n; i++) {
                f[i] = Math.max(f[i - 1], i + nt[i]);
                if(f[i] == n) return true;
                if(f[i] == i) return false;

            }

            return true;
        }
    }
}
