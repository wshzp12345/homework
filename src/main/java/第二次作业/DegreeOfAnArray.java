package 第二次作业;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray { class Solution {
    private Map<Integer,Indexx> map = new HashMap<>();
    private int max = 0;
    private List<Integer> list = new ArrayList<>();
    public int findShortestSubArray(int[] nums) {
        // 遍历 记录 3个点：频率 最小 下标 最大下标
        for(int i = 0; i< nums.length;i++) {
            if(map.containsKey(nums[i])){
                Indexx cur = map.get(nums[i]);
                cur.last = i;
                cur.count++;
                if(cur.count==max) list.add(nums[i]);
                if(cur.count>max) {
                    list.clear();
                    list.add(nums[i]);
                    max = cur.count;
                }
            }else {
                Indexx cur = new Indexx();
                cur.first = i;
                cur.last = i;
                cur.count = 1;
                map.put(nums[i], cur);
                if(cur.count==max) list.add(nums[i]);
                if(cur.count>max) {
                    list.clear();
                    list.add(nums[i]);
                    max = cur.count;
                }
            }
        }
        // 根据结果 找到最大的。
        int res = 50001;
        for(Integer i : list) {
            res = Math.min(res, map.get(i).last-map.get(i).first +1);
        }
        return res;
    }
}

    class Indexx {
        int first;
        int last;
        int count;
    }
}
