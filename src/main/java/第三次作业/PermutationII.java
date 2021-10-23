package 第三次作业;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
    class Solution {

        public List<List<Integer>> permute(int[] nums) {


            n = nums.length;
            Arrays.sort(nums);

            num = new int[n];


            for (int i = 0; i < n; i++) num[i] = nums[i];


            used = new boolean[n];


            per = new ArrayList<Integer>();


            ans = new ArrayList<List<Integer>>();


            dfs(0);


            return ans;

        }

        private void dfs(int depth) {
            if (depth == n) {
                ans.add(new ArrayList<Integer>(per));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (used[i]) continue;
                if(i > 0&& num[i] == num[i-1] && used[i-1]== false) continue;
                used[i] = true;
                per.add(num[i]);
                dfs(depth + 1);
                per.remove(per.size() - 1);
                used[i] = false;

            }

        }

        private int n;
        private int[] num;
        private boolean[] used;
        private List<Integer> per;
        private List<List<Integer>> ans;
    }
}
