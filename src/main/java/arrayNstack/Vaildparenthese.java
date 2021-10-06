package arrayNstack;

import java.util.Stack;

public class Vaildparenthese {
    class Solution {
        private Stack<Character> stack= new Stack<>();
        public boolean isValid(String input) {
            char[] ss = input.toCharArray();
            for(char s : ss) {
                if(s=='(' ||s=='{' ||s=='['  ) stack.push(s);
                if((s==')' ||s==']' ||s=='}'  )) {
                    if(stack.isEmpty()) return false;
                    char cur = stack.pop();
                    if(s==')' && cur != '(') return false;
                    if(s==']' && cur != '[') return false;
                    if(s=='}' && cur != '{') return false;
                }
            }
            if (!stack.isEmpty()) return false;
            return true;
        }
    }
}
