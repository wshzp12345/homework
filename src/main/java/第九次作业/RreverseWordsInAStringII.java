package 第九次作业;

public class RreverseWordsInAStringII {
    class Solution {
        public void reverseWords(char[] s) {
            int st = 0;
            int e = s.length- 1;
            reverse(s,st,e);

            int startWord = 0;
            int endWord = 0;
            for(int i = 0; i < s.length; i++) {
                if(s[i] == ' '){
                    endWord = i - 1;
                    reverse(s,startWord, endWord);
                    startWord = i + 1;
                }
                if(i == s.length - 1) {
                    endWord = i;
                    reverse(s,startWord,endWord);
                }
            }



        }

        void reverse(char[] s, int i, int j){
            while(i < j) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
        }
    }
}
