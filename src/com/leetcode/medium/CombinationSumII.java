package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 排序
        backTrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remains, int start) {
        if (remains < 0) {
            return;
        } else if (remains == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                tempList.add(nums[i]);
                backTrack(list, tempList, nums, remains - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
