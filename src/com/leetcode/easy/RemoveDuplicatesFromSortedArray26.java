package com.leetcode.easy;

public class RemoveDuplicatesFromSortedArray26 {

    public static int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums) {
            if (n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
        // if (nums.length == 0) return 0;
        // int i = 0;
        // for (int j = 1; j < nums.length; j++) {
        // if (nums[j] != nums[i]) {
        // i++;
        // nums[i] = nums[j];
        // }
        // }
        // return i + 1;

    }

    public static void main(String[] args) {
        System.out.print(removeDuplicates(new int[] {1, 1, 2}));
    }
}
