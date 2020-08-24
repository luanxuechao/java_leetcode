package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII59 {
    public int[][] generateMatrix(int n) {
        List<int[]> result = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        if (bottom < 0) {
            return result.toArray(new int[result.size()][]);
        }
        int right = n - 1;
        int currentNum = 1;
        for (int i = 0; i <= bottom; i++) {
            result.add(top, new int[n]);
        }
        while (true) {
            for (int i = left; i <= right; i++) {
                int[] currentList = result.get(top);
                currentList[i] = currentNum;
                currentNum++;
            }
            top++;
            if (left > right || top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                int[] currentList = result.get(i);

                currentList[right] = currentNum;
                currentNum++;
            }
            right--;
            if (left > right || top > bottom) {
                break;
            }
            for (int i = right; i >= left; i--) {
                int[] currentList = result.get(bottom);

                currentList[i] = currentNum;
                currentNum++;
            }
            bottom--;
            if (left > right || top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                int[] currentList = result.get(i);
                currentList[left] = currentNum;
                currentNum++;
            }
            left++;
            if (left > right || top > bottom) {
                break;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
