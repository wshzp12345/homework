package 第九次作业;

public class ReverseOnlyLetters {
    class Solution {
        public String reverseOnlyLetters(String s) {
            char [] c  = s.toCharArray();
            int i = 0;
            int j = c.length - 1;
            while(i < j) {
                while(i < j && !isAlph(c[i])  ) i++;
                while(!isAlph(c[j]) && j > i) j--;
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i ++;
                j --;

            }

            return new String(c);
        }

        boolean isAlph(char cur) {
            return (cur >= 'A' && cur <= 'Z') || (cur >= 'a' && cur <= 'z') ;
        }
    }
}
