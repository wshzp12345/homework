package 第六次作业;

public class NumberofLongestIncreasingSubsequence {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            int []f = new int [n];
            int [] count = new int[n];
            // int [] pre = new int[n];
            for(int i = 0;i < n;i++) {
                f[i] = 1;
                count[i] = 1;
                //     pre[i] = -1;
            }
            for(int i = 1;i < n;i++) {
                for(int j = 0 ; j<i;j ++) {
                    if(nums[i]>nums[j] ) {
                        if( f[i] < f[j] + 1 ){
                            f[i] = f[j]+1;
                            count[i] = count[j];
                        }else if(f[i] == f[j] + 1 ){
                            count[i] += count[j];
                        }
                    }
                }
            }
            int ans = 0;
            int res = 0;
            //  int end = -1;
            for(int i = 0;i<n; i++) {
                if(res < f[i]) {
                    res = f[i];
                    ans = count[i];
                    //       end = i;
                }else if(f[i] == res) {
                    ans += count[i];
                }
            }
            //       print(nums,pre,end);
            return ans;
        }


    }
}
