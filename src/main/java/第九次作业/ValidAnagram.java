package 第九次作业;

public class ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            int [] sindex = new int[26];
            int [] tindex = new int[26];
            int n = s.length();
            if(n != t.length()) return false;
            for(int i = 0; i < n; i ++) {
                sindex[s.charAt(i) - 'a'] ++;
                tindex[t.charAt(i) - 'a'] ++;
            }

            for(int i = 0; i < 26; i ++) {
                if(sindex[i] != tindex[i]) return false;
            }
            return true;
        }
    }
}
