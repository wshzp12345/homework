package arrayNstack;

public class RemoveDuplicatedfromSortedArray {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int c = 0;
            for(int i=0; i< nums.length; i++) {
                if(i==0 ||nums[i] != nums[c-1]) {

                    nums[c] = nums[i];
                    c++;
                }
            }
            return c;
        }
    }
}
