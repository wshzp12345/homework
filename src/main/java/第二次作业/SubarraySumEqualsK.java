package 第二次作业;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // 求前缀和 s[]
            int s [] = new int[nums.length+1];
            s[0] = 0;
            for(int i = 1; i <=nums.length; i ++) {
                s[i] = s[i-1] + nums[i-1];
            }
            // 从点j 开始往前找 找到 等于 k = s[j] - S[i] 的 是S[i] 0<=i <j的个数
            //通过hashmap 存储 S[i] 和个数
            Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            map.put(0, 1);
            for(int i = 1; i<= nums.length; i++) {
                if( map.containsKey(s[i] - k)) res +=map.get(s[i] - k);
                if(map.containsKey(s[i])) {
                    map.put(s[i],map.get(s[i])+1);
                } else {
                    map.put(s[i], 1);
                }
            }
            return res;
        }
    }
}
