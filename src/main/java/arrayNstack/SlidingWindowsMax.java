package arrayNstack;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowsMax {
    class Solution {
        private Deque<Integer> d = new LinkedList<>();
        public int[] maxSlidingWindow(int[] nums, int k) {
            int [] res = new int[nums.length-k+1];
            for(int i = 0; i < nums.length; i++) {
                // 窗口的移动
                while(!d.isEmpty() && (i-d.getFirst()) >= k) d.removeFirst();
                // 保持单调性
                while(!d.isEmpty() && nums[d.getLast()]<= nums[i]) d.removeLast();
                d.addLast(i);
                // 结果的赋值
                if(i>=k-1) {
                    res[i-(k-1)] = nums[d.getFirst()];
                }

            }
            return res;
        }
    }
}
