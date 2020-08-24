package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            result.add(newInterval);
            return result.toArray(new int[result.size()][]);
        }
        if (newInterval.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] mergeInterval = new int[] {newInterval[0], newInterval[1]};
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                continue;
            }
            if (intervals[i][0] > newInterval[1]) {
                result.add(intervals[i]);
                continue;
            }
            mergeInterval[0] = Math.min(mergeInterval[0], intervals[i][0]);
            mergeInterval[1] = Math.max(mergeInterval[1], intervals[i][1]);
        }
        result.add(mergeInterval);
        int[][] results = result.toArray(new int[result.size()][]);
        Arrays.sort(results, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        return results;
    }
}
