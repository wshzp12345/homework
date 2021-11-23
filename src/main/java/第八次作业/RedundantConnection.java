package 第八次作业;

public class RedundantConnection {
    class Solution {
        private int fa [];
        private int n;

        public int[] findRedundantConnection(int[][] edges) {
            n = edges.length;
            fa = new int[n + 1];
            for(int i = 0; i < n; i ++) fa[i] = i;
            for(int [] edge : edges) {
                if(find(edge[0]) == find(edge[1])) return edge;
                else {
                    unionSet(edge[0],edge[1]);
                }
            }
            return null;
        }

        private int find(int x) {
            if(x == fa[x]) return x;
            return fa[x] = find(fa[x]);
        }

        private void unionSet(int x, int y) {
            x = find(x);
            y = find(y);
            if(x != y) fa[x] = y;
        }
    }
}
