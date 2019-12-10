package com.leetcode.medium;

/**
 * @author lxc
 * @Date 2019/12/10
 */
public class ProductofArrayExceptSelf238 {
    public static int[] productExceptSelf(int[] nums) {
        int total = 1;
        int[] rets = new int[nums.length];
        int len = nums.length;
        int zeroIndex = -1;
        int zeroCount = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
                continue;
            }
            total = total * nums[i];
        }
        if (zeroCount > 1) {
            return rets;
        }
        if (zeroIndex > -1) {
            rets[zeroIndex] = total;
            return rets;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                rets[i] = 0;
                continue;
            }
            rets[i] = total / nums[i];
        }
        return rets;
    }

    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[] {1, 0}));
    }
}
