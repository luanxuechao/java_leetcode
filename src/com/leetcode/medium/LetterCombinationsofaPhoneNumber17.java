package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber17 {
    public static List<String> letterCombinations(String digits) {
        List<String> result =new ArrayList<>();
        if(digits == null || digits.isEmpty())
            return result;
        result.add("");
        String []btns = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i =0 ; i < digits.length() ;i++)
        {
            List<String> res = new ArrayList<>();
            String letter = btns[digits.charAt(i)-'0'];
            for(int j = 0 ; j < result.size();j++)//遍历上一个列表，取出每一个元素，并和新的元素的每一个字符加起来保存
            {
                for(int k = 0; k< letter.length(); k++)//遍历当前数字对应的所有字符
                {
                    res.add(result.get(j)+letter.charAt(k));
                }
            }
            result = res;
        }
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        letterCombinations("23");
    }

}

