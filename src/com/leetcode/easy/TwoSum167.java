package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lxc
 * @Date 2019/12/11
 */
public class TwoSum167 {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] rets = new int[2];
        for (int i = 0, len = numbers.length; i <= len - 1; i++) {
            int ret = target - numbers[i];
            if (map.containsKey(ret)) {
                rets[0] = map.get(ret) + 1;
                rets[1] = i + 1;
                break;
            } else {
                map.put(numbers[i], i);
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        twoSum(new int[] {2, 3, 4}, 6);
    }
}
