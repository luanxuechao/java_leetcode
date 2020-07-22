package com.leetcode.medium;

public class FirstMissingPositive41 {
    // public int firstMissingPositive(int[] nums) {
    // Map<Integer, Boolean> map = new HashMap<>();
    // int max = Integer.MAX_VALUE;
    // for (int num : nums) {
    // max = Math.max(max, num);
    // map.put(num, true);
    // }
    // for (int i = 1; i < max; i++) {
    // if (map.get(i) == null) {
    // return i;
    // }
    // }
    // return 1;
    // }
    // 初始化一个空的数组 把数字放起num-1的位置，遍历数组缺失的即为最小正数组
    public int firstMissingPositive(int[] nums) {
        int[] a = new int[nums.length];
        for (int num : nums) {
            if (num >= 1 && num <= nums.length) {
                a[num - 1] = num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (a[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        new FirstMissingPositive41().firstMissingPositive(new int[] {1});
    }
}
