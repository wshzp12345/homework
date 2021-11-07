package 第五次作业;

public class SeearchA2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int l= 0; int r = m * n-1;
            int mid=0 , midX , midY ;
            while(l <= r) {
                mid = (l+r)>> 1;
                midX = mid/n;
                midY = mid%n;

                if(matrix[midX][midY] == target) return true;
                if(matrix[midX][midY] > target){
                    r = mid -1;
                } else {
                    l = mid + 1;
                }

            }

            return false;
        }
    }
}
