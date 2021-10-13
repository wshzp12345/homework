package hashSetMap;

public class CountNumberofNiceSubarrays {
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int s[] = new int[nums.length+1];
            s[0]=0;
            int result=0;
            for(int i = 1; i <= nums.length; i++) {
                s[i] = s[i-1] + nums[i-1]%2;
            }
            int [] count = new int[nums.length+1];
            count[0]++;
            for(int i = 1; i<= nums.length; i++) {
                if (s[i] - k >=0) result+= count[s[i] - k ];
                count[s[i]]++;
            }

            return result;

        }
    }
}
