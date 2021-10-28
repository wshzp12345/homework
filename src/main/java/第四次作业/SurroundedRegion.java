package 第四次作业;

import java.util.Deque;
import java.util.LinkedList;

public class SurroundedRegion {
    class Solution {
        // 找到边上的Q 标记为A
        // 对边上的Q进行 bfs
        // Q 标记为A

        private Deque<int[]> q = new LinkedList<>();
        int m,n;
        private int [] dx= {-1,0,0,1};
        private int [] dy = {0,-1,1,0};


        public void solve(char[][] board) {
            m = board.length;
            if(m==0) return;
            n = board[0].length;
            //System.out.println("m="+m+" n="+n);
            for(int i=0;i<n;i++) {
                if(board[0][i]=='O'){
                    q.addLast(new int[]{0,i});
                    board[0][i] = 'A';
                }

                if(board[m-1][i]=='O'){
                    q.addLast(new int[]{m-1,i});
                    board[m-1][i] = 'A';
                }
            }

            for(int i=1;i<m-1;i++) {
                if(board[i][0]=='O'){
                    q.addLast(new int[]{i,0});
                    board[i][0] = 'A';
                }

                if(board[i][n-1]=='O'){
                    q.addLast(new int[]{i,n-1});
                    board[i][n-1] = 'A';
                }
            }

            while(!q.isEmpty()) {
                int c []  = q.removeFirst();

                for(int i=0; i< dx.length;i++) {
                    int x = c[0] + dx[i];
                    int y = c[1] + dy[i];
                    if(invalid(x,y)|| board[x][y]!='O') continue;
                    board[x][y] = 'A';
                    q.addLast(new int[]{x,y});
                }
            }

            for(int i = 0; i<m;i++)
                for(int j =0;j<n;j++) {
                    if(board[i][j]=='O') {
                        board[i][j]='X';
                    } else if(board[i][j]=='A') board[i][j]='O';
                }

        }

        private boolean invalid(int i, int j) {
            return i<0 || j<0 || i >=m || j >= n;
        }
    }
}
