package 第九次作业;

public class LengthOfLastWord {
    class Solution {
        public int lengthOfLastWord(String s) {
            char[] c = s.toCharArray();
            int res = 0;
            boolean endOfLast = false;
            for(int i = c.length - 1; i>=0; i--) {
                if(c[i] == ' ') {
                    if(res != 0){
                        return res;
                    }else {
                        continue;
                    }
                } else {
                    res++;
                }

            }
            return res;
        }
    }
}
