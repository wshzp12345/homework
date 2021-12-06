package 第九次作业;

public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int res = 0;
            char temp = ' ';
            boolean endOfString = false;
            while(!endOfString) {

                for(int i = 0; i < strs.length; i ++) {
                    if(strs[i].length() == res) {
                        endOfString = true;
                        break;
                    }
                    if(i == 0){
                        temp = strs[i].charAt(res);
                    }else{
                        if(temp != strs[i].charAt(res)) {
                            endOfString = true;
                            break;
                        }
                    }

                }
                res ++;
            }

            return strs[0].substring(0,res-1);

        }
    }
}
