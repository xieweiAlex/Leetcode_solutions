package October.week4;

import java.util.Arrays;

/*

 * explain:
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

 * url:
https://leetcode.com/problems/meeting-rooms/description/
 * solution:

*/
public class CanAttendMeetings {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null) return false;

        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }

        return true;
    }

}
