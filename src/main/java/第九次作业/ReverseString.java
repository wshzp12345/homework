package 第九次作业;

public class ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            int i = 0;
            int j = s.length - 1;
            char temp = 0;
            while(i<j) {
                temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
        }
    }
}
