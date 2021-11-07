package 第四次作业;

import java.util.*;

public class DesignTwitter {
    class Twitter {

        private PriorityQueue<TS> hotFeeds ;
        private Map<Integer,TS> tweets;
        private Map<Integer, Set<Integer>> relations;
        private int timestamp = 0;
        private final int maxC = 10;
        public Twitter() {
            hotFeeds = new PriorityQueue<TS>((t1,t2)-> t2.timestamp - t1.timestamp);
            relations = new HashMap<>();
            tweets = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            TS cur = tweets.get(userId);
            TS newT = new TS(timestamp++,tweetId);
            if(cur!=null){
                newT.next = cur;
            }
            tweets.put(userId,newT);
        }

        public List<Integer> getNewsFeed(int userId) {
            // 找到所有的 链表
            // 通过 hotFeeds 获取 最新 10个，
            // 返回 list
            List<Integer> res = new ArrayList<>();
            hotFeeds.clear();
            List<TS> links = new ArrayList<>();
            Set<Integer> s = relations.get(userId);
            if(s == null) s = new HashSet();
            s.add(userId);
            for(Integer id:s) {
                links.add(tweets.get(id));
            }
            System.out.println(links);
            for(TS cur: links){
                if(cur!=null)
                    hotFeeds.add(cur);
            }
            //System.out.println(hotFeeds);
            // System.out.println(tweets);
            for(int i = 0; i < maxC; i++) {
                if(hotFeeds.isEmpty()) break;
                TS newest = hotFeeds.poll();
                res.add(newest.tweetId);
                if(newest.next !=null) hotFeeds.add(newest.next);

            }
            return res;
        }
        Arrays.sort()

        public void follow(int followerId, int followeeId) {
            if(followeeId == followerId) return;
            if(!relations.containsKey(followerId)){
                relations.put(followerId,new HashSet());
            }
            if(relations.get(followerId).contains(followeeId)) return;
            relations.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if(!relations.containsKey(followerId)){
                return;
            }
            relations.get(followerId).remove(followeeId);
        }
    }
    class TS {
        int timestamp;
        int tweetId;
        TS next;
        public TS(int timestamp, int tweetId) {this.timestamp = timestamp; this.tweetId = tweetId;}
        public String toString(){
            return "timestamp="+timestamp+" tweetId"+tweetId;
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
