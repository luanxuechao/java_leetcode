package com.leetcode.easy;


// 每次判断后2位是否有#
// 从后往前找 执行效率更高
public class DecryptStringfromAlphabettoIntegerMapping1309 {
    public static  String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        for(int index =0; index<s.length();){
            boolean isBe =false;
            if(index+2<s.length()){
                if("#".equals(s.substring(index+2,index+3))){
                    isBe=true;
                }
            }
            if(!isBe){
                System.out.println(s.substring(index,index+1));
                result.append((char)(Integer.valueOf(s.substring(index,index+1)).intValue()+96));
                index++;
            }else {
                result.append((char)(Integer.valueOf(s.substring(index,index+2)).intValue()+96));
                index = index+3;
            }
        }
        return result.toString();
    };


    public static void main(String[] args) {
        System.out.print(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}
