package hashSetMap;

import java.util.*;

public class GroupAnagrams {
    class Solution {
        private List<List<String>> res = new ArrayList<>();
        private Map<String,Integer> map = new HashMap<>();
        public List<List<String>> groupAnagrams(String[] strs) {

            for(String curS: strs) {
                addIntoList(getIndex(curS),curS);
            }

            return res;

        }

        private int getIndex(String curs) {
            char [] cs= curs.toCharArray();
            Arrays.sort(cs);
            String temp = new String(cs);
            if(map.containsKey(temp)) return map.get(temp);
            else {
                map.put(temp,res.size());
            }
            return res.size();
        }

        private void addIntoList(int index, String curS) {
            if(index == res.size()){
                res.add(new ArrayList());
            }
            res.get(index).add(curS);
        }
    }
}
