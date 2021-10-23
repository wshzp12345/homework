package 第三次作业;

public class ConstructBinaryTreeFromInorderAndPostorder {
    class Solution {
        int [] inorder;
        int [] postorder;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;
            return build(0,inorder.length-1,0, postorder.length-1);
        }

        private TreeNode build(int i1, int i2, int p1, int p2) {
            if(p1>p2) return null;
            TreeNode node = new TreeNode(postorder[p2]);
            int m = i1;
            while(postorder[p2] != inorder[m]) m++;
            node.left = build(i1,m-1,p1,p1+(m-i1)-1);
            node.right = build(m+1,i2,p1+(m-i1),p2-1);
            return node;
        }
    }
}
