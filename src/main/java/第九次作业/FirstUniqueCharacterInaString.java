package 第九次作业;

public class FirstUniqueCharacterInaString {
    class Solution {
        public int firstUniqChar(String s) {
//            s.le
            char [] cc = s.toCharArray();
            boolean check [] = new boolean[cc.length];
            //   for(int i = 0; i < cc.length; i ++) check[i] = false;
            for(int i = 0; i < cc.length; i++) {
                if(!check[i]){
                    for(int j = i + 1; j < cc.length; j++) {
                        //if(check[i]) break;
                        if( cc[i] == cc[j]){
                            check[i] = true;
                            check[j] = true;
                            //break;
                        }
                    }
                }

                // System.out.println(Arrays.toString(check));
                if(!check[i]) return i;
            }
            return -1;
        }
    }
}
