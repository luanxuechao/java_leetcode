package com.leetcode.medium;

import java.util.*;

// 不太懂 有待复习
public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> ans = new ArrayList<>(); // opt 数组
        Arrays.sort(candidates);// 将数组有序，这样可以提现结束循环
        for (int sum = 0; sum <= target; sum++) { // 从 0 到 target 求出每一个 opt
            List<List<Integer>> ans_sum = new ArrayList<List<Integer>>();
            for (int i = 0; i < candidates.length; i++) { // 遍历 nums
                if (candidates[i] == sum) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(candidates[i]);
                    ans_sum.add(temp);
                } else if (candidates[i] < sum) {
                    List<List<Integer>> ans_sub = ans.get(sum - candidates[i]);
                    // 每一个加上 nums[i]
                    for (int j = 0; j < ans_sub.size(); j++) {
                        List<Integer> temp = new ArrayList<Integer>(ans_sub.get(j));
                        temp.add(candidates[i]);
                        ans_sum.add(temp);
                    }
                } else {
                    break;
                }
            }
            ans.add(sum, ans_sum);
        }
        return removeDuplicate(ans.get(target));
    }

    private List<List<Integer>> removeDuplicate(List<List<Integer>> list) {
        Map<String, String> ans = new HashMap<String, String>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> l = list.get(i);
            Collections.sort(l);
            String key = "";
            // [ 2 3 4 ] 转为 "2,3,4"
            for (int j = 0; j < l.size() - 1; j++) {
                key = key + l.get(j) + ",";
            }
            key = key + l.get(l.size() - 1);
            ans.put(key, "");
        }
        // 根据逗号还原 List
        List<List<Integer>> ans_list = new ArrayList<List<Integer>>();
        for (String k : ans.keySet()) {
            String[] l = k.split(",");
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < l.length; i++) {
                int c = Integer.parseInt(l[i]);
                temp.add(c);
            }
            ans_list.add(temp);
        }
        return ans_list;
    }

    public static void main(String[] args) {
        new CombinationSum39().combinationSum(new int[] {8, 7, 4, 3}, 11);
    }
}
