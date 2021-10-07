package 第一次作业;

import java.util.Stack;

public class MaximalRectangle {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            // 1 每一层数据当做一个 柱状图（为了0 则忽略之前的高度，不为零则累加高度）
            // 2 每次按照柱状图计算获取最大值，比较获取 全局最大的数
            if(matrix.length == 0) return 0;
            int [] curRow = new int[matrix[0].length];
            //int [] preRow = new int[matrix[0].length];
            int ans = 0;
            for(char [] row : matrix) {
                for(int i=0; i< row.length; i++) {
                    if(row[i] == '1') {
                        curRow[i] +=1;
                    }else {
                        curRow[i] = 0;
                    }
                    //System.arraycopy(curRow, 0, preRow, 0, curRow.length);
                }
                ans = Math.max(ans,largestRectangleArea(curRow));
            }
            return ans;
        }

        private Stack<Integer> stack = new Stack<>();
        public int largestRectangleArea(int[] heights) {
            int ans = 0;

            int[] tmp = new int[heights.length + 2];
            System.arraycopy(heights, 0, tmp, 1, heights.length);
            for(int i = 0; i < tmp.length; i++) {
                int accumulateWidth = 1;
                while(!stack.isEmpty() && tmp[stack.peek()] > tmp[i]) {
                    int h =  tmp[stack.pop()];
                    ans = Math.max(ans, (i - stack.peek()-1)* h);
                }
                stack.push(i);
            }
            return ans;
        }
    }
}
