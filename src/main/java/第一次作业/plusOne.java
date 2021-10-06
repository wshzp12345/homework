package 第一次作业;

class Solution {
    public int[] plusOne(int[] digits) {
        boolean increase = false;
        for(int i = digits.length-1; i>=0;i--) {
            int r = digits[i] +1;
            if(r>9) {
                digits[i] = 0;
                increase = true;
            } else {
                digits[i] = r;
                increase = false;
                break;
            }
        }
        if(increase) {
            int[] results = new int[digits.length+1];
            for(int i=0; i< results.length;i++) {
                if(i==0) results[i] = 1;
                else results[i] = 0;
            }
            return results;
        }
        return digits;
    }
}