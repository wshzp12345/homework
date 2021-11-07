package 第五次作业;

public class CapacityToShipPackagesWithinDDays {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int l =0, r= 0;
            for(int w : weights) {
                l = Math.max(w,l);
                r+=w;
            }

            while(l<r){
                int mid = (l+r) >> 1;
                // 找到从左边开始 第一个true
                if(canShip(weights,days,mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return r;
        }

        private boolean canShip(int [] weights, int days, int capacity) {
            int load = 0;
            int round = 1;
            for(int w : weights) {
                if(load+w<= capacity) {
                    load += w;
                }else{
                    round++;
                    load = w;
                }
            }

            return round<= days;
        }
    }
}
