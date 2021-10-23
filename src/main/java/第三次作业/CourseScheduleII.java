package 第三次作业;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleII {
    class Solution {

        List<List<Integer>> to = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        int[] inDegree;
        int[] lessons;
        int indexOfLessons=0;
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            inDegree = new int[numCourses];
            lessons = new int[numCourses];
            for(int i=0;i<numCourses;i++) to.add(new ArrayList<>());
            for(int [] prerequisite: prerequisites ) {
                int a= prerequisite[0];
                int b=  prerequisite[1];
                to.get(b).add(a);
                inDegree[a]++;
            }

            for(int i =0;i<numCourses;i++) {
                if(inDegree[i] == 0) q.addLast(i);
            }
            System.out.println(q);
            System.out.println(to);

            if(q.isEmpty()) return new int[]{};
            while(!q.isEmpty()) {
                int cur = q.removeFirst();
                lessons[indexOfLessons++]=cur;
                // reduce degree, for every relative courses.
                for(Integer next: to.get(cur)) {
                    inDegree[next]--;
                    if(inDegree[next] ==0) q.addLast(next);
                }
            }
            System.out.println(indexOfLessons);
            System.out.println(numCourses);
            if(indexOfLessons != numCourses )return new int[]{};
            return lessons;
        }
    }
}
