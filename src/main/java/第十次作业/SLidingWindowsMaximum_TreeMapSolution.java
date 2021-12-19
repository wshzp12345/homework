package 第十次作业;

import java.util.TreeMap;

public class SLidingWindowsMaximum_TreeMapSolution {
    class Solution {
        // 单调队列queue 保持最大值
        TreeMap<Integer,Integer> set = new TreeMap<>();
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;

            int res [] = new int[n - k + 1];

            for(int i = 0 ; i < n; i ++ ) {
                set.put(nums[i], i);
                if(i >= k - 1) {
                    int key = set.lastKey();
                    int value = set.get(key);
                    while( value < i-k+1) {
                        set.remove(key);
                        key = set.lastKey();
                        value = set.get(key);
                    }
                    res[i-k+1] = key ;
                    //set.remove(res[i-k+1]);
                }
            }

            return res;
        }
    }
}
