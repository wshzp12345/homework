package 第九次作业;

public class ToLowerCase {
    class Solution {
        public String toLowerCase(String s) {
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                if (c>= 'A' && c <= 'Z') c += 32;
                sb.append(c);
            }

            return sb.toString();
        }
    }
}
