package arrayNstack;

public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index=nums1.length-1;
            for(int i = m-1, j = n-1 ; i>=0 || j>=0;) {
                if(i>=0 && (j==-1 || nums1[i] > nums2[j])){
                    nums1[index] = nums1[i];
                    index--;
                    i--;
                } else {
                    nums1[index] = nums2[j];
                    index--;
                    j--;
                }
            }
        }
    }
}
