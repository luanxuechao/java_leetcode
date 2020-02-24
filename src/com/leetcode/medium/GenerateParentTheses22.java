package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// 回溯法
public class GenerateParentTheses22 {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backTrace("",result,0,0,n);
        return  result;
    }
    public  static  void backTrace(String str,List<String> list,int open,int close, int max){
        if(str.length() == 2*max){
            list.add(str);
            return;
        }
        if(open < max)
            backTrace(str+"(",list, open+1, close, max);
        if(close < open)
            backTrace(str+")",list,  open, close+1, max);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
