package 第二次作业;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    class Solution {
        private Map<String, Integer> map = new HashMap<>();
        public List<String> subdomainVisits(String[] cpdomains) {
            for(String cur : cpdomains) {
                handle(cur);
            }
            return buildRes();
        }

        private void handle(String cur) {
            String [] ss = cur.split(" ");
            int curN = Integer.parseInt(ss[0]);
            parseDom(ss[1],curN);

        }

        private void parseDom(String ss,int curN) {
            int i = 0;
            addToMap(ss,curN);
            while(true){
                i = ss.indexOf('.');
                if(i==-1){
                    break;
                }
                ss = ss.substring(i+1);
                addToMap(ss,curN);

            }

        }

        private void addToMap(String ss, int n) {
            if(map.containsKey(ss)){
                map.put(ss,map.get(ss) + n);
            } else {
                map.put(ss,n);
            }
        }

        private List<String> buildRes() {
            List<String> list = new ArrayList<>();
            for(String s: map.keySet()) {
                list.add(buildR(s, map.get(s)));
            }
            return list;
        }

        private String buildR(String s, int curN) {
            return curN + " " + s;
        }
    }
}
