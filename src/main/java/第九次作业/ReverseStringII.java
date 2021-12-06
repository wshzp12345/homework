package 第九次作业;

public class ReverseStringII {
    class Solution {
        public String reverseStr(String s, int k) {

            char [] ss = s.toCharArray();
            int n = ss.length;
            for(int i = 0; i < n ; i += 2 * k) {
                if(i + k > n) reverse(ss, i, n-1);
                else reverse(ss,i,i+k-1);
            }
            return new String(ss);
        }

        void reverse(char[] s, int i , int j){
            char temp = 0;
            while(i<j ) {
                temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
        }
    }
}
