package 第五次作业;

public class OnlineElection {
    class TopVotedCandidate {
        int []persons;
        int []times;
        public TopVotedCandidate(int[] persons, int[] times) {
            this.persons = persons;
            this.times = times;
        }

        public int q(int t) {
            // find first element  <= t
            int l = -1;
            int r = persons.length-1;
            while(l < r) {
                int mid = (l+r+1) >> 1;
                if(times[mid]<= t) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int [] count = new int [persons.length];
            int maxC=0;
            int lead=0;
            for(int i=0;i <= r;i++) {
                count[persons[i]]++;

                if(count[persons[i]] >= maxC) {
                    lead = persons[i];
                    maxC = count[persons[i]];
                }
            }
            return lead;
        }
    }

}
