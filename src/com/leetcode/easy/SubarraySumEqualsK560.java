package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lxc
 * @Date 2019/12/11
 */

/**
 * 使用一个字典保存数组某个位置之前的数组和，然后遍历数组求和，这样当我们求到一个位置的和的时候， 向前找sum-k是否在数组中，如果在的话，更新结果为之前的结果+(sum-k出现的次数)。同时， 当前这个sum出现的次数就多了一次。
 *
 * 这个字典的意义是什么呢？其意义就是我们在到达i位置的时候，前i项的和出现的次数的统计。 我们想找的是在i位置向前的连续区间中，有多少个位置的和是k。有了这个统计，我们就不用向前一一遍历找sum - k在哪些位置出现了，
 * 而是直接得出了前面有多少个区间。所以，在每个位置我们都得到了以这个位置为结尾的并且和等于k的区间的个数，所以总和就是结果。
 * 
 *
 */
public class SubarraySumEqualsK560 {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        for (int i : nums) {
            sum += i;
            ans += map.getOrDefault(sum - k, 0);
            if (sum == k) {
                ans++;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.print(ans);
        return ans;
    }

    public static void main(String[] args) {
        subarraySum(new int[] {100, 1, 2, 3, 4}, 6);
    }
}
