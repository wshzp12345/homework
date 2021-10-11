package hashSetMap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            Map<Integer,Integer> n = new HashMap<>();

            for(int i = 0; i < nums.length; i++) {
                n.put(nums[i],i);
            }

            for(int i = 0; i< nums.length; i++ ) {
                if(n.containsKey(target-nums[i]) ) {
                    res[0] = i;
                    res[1] = n.get(target-nums[i]);
                    if(res[0] == res[1]) continue;
                    return res;
                }
            }
            return res;
        }
    }
}
