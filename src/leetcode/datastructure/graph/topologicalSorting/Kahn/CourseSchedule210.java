package leetcode.datastructure.graph.topologicalSorting.Kahn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3869/
public class CourseSchedule210 {

    public static void main(String[] args) {
        //First element: must take before doing second element:
        //Example: [1, 0]     0 <------- 1 (1 must be taken before 0)
        int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
        final var courseSchedule = new CourseSchedule210();
        Arrays.stream(courseSchedule.test(4, null))
                .forEach(e -> System.out.print(e + " "));
    }

    /*TEST*/
    public int[] test(int n, int[][] prerequisites) {
        int[] result = new int[n];
        if(n == 0) return result;
        if(prerequisites == null || prerequisites.length == 0) {
            for(int i = 0; i < n; i++) {
                result[i] = i;
                return result;
            }
        }
        int[] inDegree = new int[n];
        for(int[] pre: prerequisites) {
            inDegree[pre[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int d: inDegree) {
            if(d == 0) q.add(d);
        }
        if(q.isEmpty()) return new int[0];
        int index = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            result[index] = node;
            index++;
            for(int[] pre: prerequisites) {
                if(pre[0] == node) {
                    inDegree[pre[1]]--;
                    if(inDegree[pre[1]] == 0) {
                        q.add(pre[1]);
                    }
                }
            }
        }
        for(int i: inDegree) {
            if(i != 0) return new int[0];
        }
        return result;
    }
    /*END TEST*/











    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if(numCourses == 0) return result;
        if(prerequisites == null || prerequisites.length == 0) {
            for(int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        int[] indegree = new int[numCourses];
        Queue<Integer> zeroDegree = new LinkedList<>();
        for(int[] pre: prerequisites) {
            indegree[pre[0]]++;
        }
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) zeroDegree.add(i);
        }
        if(zeroDegree.isEmpty()) return new int[0];
        int index = 0;
        while(!zeroDegree.isEmpty()) {
            int course = zeroDegree.poll();
            result[index] = course;
            index++;
            for(int[] pre: prerequisites) {
                if(pre[1] == course) {
                    indegree[pre[0]]--;
                    if(indegree[pre[0]] == 0){
                        zeroDegree.add(pre[0]);
                    }
                }
            }
        }
        for(int in: indegree) {
            if(in != 0) {
                return new int[0];
            }
        }

        return result;
    }
}
