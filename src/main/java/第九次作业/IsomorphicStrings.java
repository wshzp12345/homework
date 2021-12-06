package 第九次作业;

public class IsomorphicStrings {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            int n = s.length();
            s = ' ' + s;
            t = ' ' + t;
            int [] sIndex = new int [n + 1];
            int [] tIndex = new int [n + 1];

            for(int i = 0; i <= n; i ++) {
                if(sIndex[i] != tIndex[i]) return false;
                if(sIndex[i] == 0 ){
                    boolean f = false;
                    for(int j = i + 1 ; j <= n; j++) {
                        if(s.charAt(i) == s.charAt(j)) {
                            sIndex[j] = i;
                            f = true;
                        }
                    }
                    if(f) {
                        sIndex[i] = i;
                    }
                }

                if(tIndex[i] == 0 ){
                    boolean f = false;
                    for(int j = i + 1 ; j <= n; j++) {
                        if(t.charAt(i) == t.charAt(j)) {
                            tIndex[j] = i;
                            f = true;
                        }
                    }
                    if(f) {
                        tIndex[i] = i;
                    }
                }

            }
            for(int i = 1; i <=n; i++){
                if(sIndex[i] != tIndex[i]) return false;
            }

            return true;


        }
    }
}
