package com.leetcode.medium;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement424 {
    public static int characterReplacement(final String s, final int k) {
        if (s.length() == 0) {
            return 0;
        }
        final String[] arr = s.split("");
        int start = 0;
        int end = 0;
        int maxCount = 0;
        final HashMap<String, Integer> map = new HashMap<String, Integer>();
        while (end < arr.length) {
            if (map.containsKey(arr[end])) {
                map.put(arr[end], map.get(arr[end]) + 1);
            } else {
                map.put(arr[end], 1);
            }
            int diffStrCount = 0;
            String maxKey = null;
            for (final String key : map.keySet()) {
                if (maxKey == null) {
                    maxKey = key;
                }
                if (key.equals(maxKey)) {
                    continue;
                }
                final int count = map.get(key);
                if (count > map.get(maxKey)) {
                    diffStrCount = diffStrCount + map.get(maxKey);
                    maxKey = key;
                } else {
                    diffStrCount = diffStrCount + map.get(key);
                }
            }
            if (diffStrCount <= k) {
                maxCount = Math.max(maxCount, end - start + 1);
            }
            if (diffStrCount > k) {
                map.put(arr[start], map.get(arr[start]) - 1);
                start++;
            }
            end++;
        }
        return maxCount;
        // int len = s.length();
        // int[] count = new int[26];
        // int start = 0, maxCount = 0, maxLength = 0;
        // for (int end = 0; end < len; end++) {
        // maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
        // while (end - start + 1 - maxCount > k) {
        // count[s.charAt(start) - 'A']--;
        // start++;
        // }
        // maxLength = Math.max(maxLength, end - start + 1);
        // }
        // return maxLength;
    }

    public static void main(final String[] args) {
        characterReplacement("ABAB", 2);
    }
}
