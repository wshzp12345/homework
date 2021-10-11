package hashSetMap;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobot {
    class Solution {
        private int direction = 0; // north 0, east 1, south 2, west 3
        private int[] moveX = {0,1,0,-1};
        private int[] moveY = {1,0,-1,0};
        private Set<Long> set = new HashSet<>();
        private int [] curIndex = {0, 0};
        private int maxRes = 0;
        public int robotSim(int[] commands, int[][] obstacles) {
            calObstacles(obstacles);
            for(int curC : commands) {
                if(curC < 0) changeDirect(curC);
                else {
                    move(curC);
                    maxRes = Math.max(maxRes,calRes());
                }
            }

            return maxRes;

        }
        private void move(int curC) {

            for(int i = 0; i < curC; i++) {
                int nextX = curIndex[0] + moveX[direction];
                int nextY = curIndex[1] + moveY[direction];
                if(set.contains(getIndex(nextX,nextY))) return;
                curIndex[0] = nextX;
                curIndex[1] = nextY;
            }
        }

        private void changeDirect(int curC) {
            direction = calDirection(curC);
        }

        private int calRes() {
            return curIndex[0]* curIndex[0] + curIndex[1] * curIndex[1];
        }

        private int calDirection(int m) {
            if(turnLeft(m)){
                return (direction + 3)%4;
            }
            if(turnRight(m)){
                return (direction + 1)%4;
            }
            return 0;
        }

        private boolean turnLeft(int m) {
            if(m==-2) return true;
            return false;
        }

        private boolean turnRight(int m) {
            if(m==-1) return true;
            return false;
        }

        private void calObstacles(int [] []obstacles){
            for(int i = 0; i< obstacles.length;i++) {

                set.add(getIndex(obstacles[i][0],obstacles[i][1]));

            }
        }

        private long getIndex(int i, int j) {
            return (30000+i)*60001+(j+30000);
        }
    }
}
