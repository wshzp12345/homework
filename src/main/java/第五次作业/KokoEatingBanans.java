package 第五次作业;

public class KokoEatingBanans {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int l = 1, r = 0;
            for(int p :piles) r = Math.max(p,r);

            while(l < r) {
                int mid = (l+r) >> 1;
                if(canFinishEating(piles,h,mid)){
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            return r;
        }

        boolean canFinishEating(int[] piles, int h, int speed) {
            int hours = 0;
            for(int p : piles){
                int need = p/speed;
                int rest = p % speed;
                hours+=need;
                if(rest > 0) hours++;
            }
            return hours <= h;
        }
    }
}
