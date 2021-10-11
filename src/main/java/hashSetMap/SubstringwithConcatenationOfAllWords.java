package hashSetMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationOfAllWords {

    class Solution {
        private int length = 0;
        private Map<String,Integer> map  = new HashMap<>();
        private List<Integer> res = new ArrayList<>();
        public List<Integer> findSubstring(String s, String[] words) {
            buildMap(words);

            for(int i = 0; i+length <=s.length();i++) {
                if(valid(s.substring(i,i+length), words[0].length())){
                    res.add(i);
                }
            }
            return res;
        }
        private boolean valid(String subs,int seq) {
            Map<String,Integer> splitMap = new HashMap<>();
            for(int i = 0; i < subs.length(); i += seq) {
                String curS = subs.substring(i, i+seq);
                addToMap(curS,splitMap);
            }
            return compareMap(splitMap, map);
        }

        private boolean compareMap(Map<String, Integer> map1,Map<String, Integer> map2) {
            for(String curS : map1.keySet()) {
                if(map2.containsKey(curS) && map2.get(curS).equals(map1.get(curS))) {

                }else {
                    return false;
                }
            }

            for(String curS : map2.keySet()) {
                if(map1.containsKey(curS) && map1.get(curS).equals(map2.get(curS))) {

                }else {
                    return false;
                }
            }
            return true;

        }

        private void buildMap(String [] words) {
            for(String w: words) {
                length += w.length();
                addToMap(w,map);
            }
        }
        private void addToMap(String w, Map<String, Integer> map1) {
            if(map1.containsKey(w)) {
                map1.put(w, map1.get(w)+1);
            } else {
                map1.put(w, 1);
            }
        }
    }
    //TODO 滑动窗口
}
