package 第九次作业;

public class ReverseWordsInAString {
    class Solution {

        StringBuilder sb;
        int n = 0;
        public String reverseWords(String s) {
            sb = new StringBuilder(s);
            //char res[] = new char[c.length];
            removeSpace();
            reverse(0,sb.length() -1);
            reverseEachWords();
            return sb.toString();
        }

        void removeSpace() {
            int indexOfContent = 0;
            while(indexOfContent < sb.length()) {
                if(sb.charAt(indexOfContent) == ' ') {
                    if(indexOfContent == 0 || sb.charAt(indexOfContent - 1) == ' ') {
                        sb.deleteCharAt(indexOfContent);
                        continue;
                    }

                }
                indexOfContent++;
            }

            while(' ' == sb.charAt(sb.length() - 1)) sb.deleteCharAt(sb.length() - 1);
        }

        void reverse(int s, int e) {
            while(s < e) {
                char temp = sb.charAt(e);
                sb.setCharAt(e, sb.charAt(s));
                sb.setCharAt(s, temp);
                e--;
                s++;
            }
        }

        void reverseEachWords() {
            int startIndex = 0;
            int endIndex = 0;
            for(int i = 0; i < sb.length(); i ++) {
                if(sb.charAt(i) == ' ') {
                    endIndex = i - 1;
                    reverse(startIndex,endIndex);
                    startIndex = i + 1;
                }
                if(i == sb.length() - 1) {
                    endIndex = i;
                    reverse(startIndex,endIndex);
                }
            }
        }


    }
}
