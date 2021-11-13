package 第六次作业;

public class ClimbingStairs {
    class Solution {

        public int climbStairs(int n) {
            if (n == 0)
                return 0;
            if (n == 1)
                return 1;
            if (n == 2)
                return 2;
            int[] climbs = new int[n+1];
            func(n , climbs);
            return climbs[n ];
        }

        private void func(int n, int[] climbs) {


            climbs[0] = 0;
            climbs[1] = 1;
            climbs[2] = 2;
            for (int i = 3; i <= n; i++) {
                climbs[i] = climbs[i - 1] + climbs[i - 2];
            }
        }
    }
}
