package com.wxp.dp;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 10521 on 2018/8/11.
 *  139. 单词拆分
 */
public class WwordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || "".equals(s) || wordDict == null || wordDict.size() == 0)
            return false;
        int sLength = s.length();
        int dictLength = wordDict.size();

        int[] dp = new int[sLength];

        for(int i = 0; i < sLength ;i++){
            for(int j = 0; j < dictLength ; j++){
                String wordStr = wordDict.get(j);
                if(wordStr.length() > i+1){
                    continue;
                }
                if(wordStr.equals(s.substring(i+1-wordStr.length(),i+1))){
                    if(i+1 == wordStr.length()){
                        dp[i] = 1;
                    }else{
                        if(dp[i] == 0){
                            dp[i] = dp[i - wordStr.length()];
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return dp[sLength-1] > 0;
    }

    public static void main(String[] args) {
        wordBreak("dogs", Arrays.asList("dog","s","gs"));
    }



}
