package October.week4;

import java.util.Arrays;

/*

 * explain:
 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

 * url:
https://leetcode.com/problems/meeting-rooms-ii/description/

 * solution:

*/
public class MinMeetingRooms {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(Interval[] intervals) {

        int starts[] = new int[intervals.length];
        int ends[] = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int room = 0;
        int endNum = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endNum]) {
                room++;
            } else {
                endNum++;
            }
        }

        return room;
    }


}
