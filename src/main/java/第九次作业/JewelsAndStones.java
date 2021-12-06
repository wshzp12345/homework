package 第九次作业;

public class JewelsAndStones {
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            char j[] = jewels.toCharArray();
            int res = 0;
            for(char s: stones.toCharArray()) {
                for(int i = 0; i < j.length; i++) {
                    if(j[i] == s) {
                        res++;
                        break;
                    }
                }

            }
            return res;
        }
    }
}
