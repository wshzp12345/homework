package 第五次作业;

public class FindMinimumInRotatedSortedArrayII {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length -1;
            int mid =0;
            while(left < right) {
                mid = (left+ right)/2;
                if(nums[mid]>nums[right]){
                    left = mid+1;
                }else if(nums[mid]<nums[right]) {
                    right = mid;
                } else{
                    right--;
                }
            }

            return nums[right];
        }
    }
}
