package topAmazonQuestions.topAmazonQuestions2.highFrequency;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRooms2 {

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        var obj = new MeetingRooms2();
        System.out.println(obj.minMeetingRooms(intervals));
    }
    /*
    Time complexity: O(N log N)
    Sorting array takes O(N log N)
    Heap (PrioritizeQ) O(N log N)
    Space complexity: O(N)
    min-heap can contain N elements in the worst case scenario.
     */
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        //Min heap
        //Prioritize smaller element
        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, (o1, o2) -> o1 - o2);
        //Sort the intervals by start time
        Arrays.sort(intervals, (el1, el2)  -> el1[0] - el2[0]);
        allocator.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++) {
            //If room due to free up earlier is free, assing room to this meeting
            if( allocator.peek() != null
                    && intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            //If new room is to be assigned
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
}
