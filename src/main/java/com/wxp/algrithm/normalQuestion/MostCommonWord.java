package com.wxp.algrithm.normalQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 最常见的单词
 * @author: wxp
 * @time: 2022/4/17 16:11
 */
public class MostCommonWord {

    public static void main(String[] args) {
        //"a, a, a, a, b,b,b,c, c"
        //["a"]
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = new String[]{"a"};
        System.out.println(mostCommonWord(paragraph,banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> wordCntMap = new HashMap<>();
        String lowerParagraph = paragraph.toLowerCase();
        lowerParagraph = lowerParagraph.replace(","," ");
        String[] words = lowerParagraph.split(" ");

        int maxCount = 0;
        String retWord = "";

        for(String word : words){
            if("".equals(word) || " ".equals(word)){
                continue;
            }
            //如果单词后面跟着标点符号，则需要将标点符号处理掉
            if(notWithPunctuation(word)){
                word = word.substring(0,word.length()-1);
            }
            //校验是否在禁用单词列表,不在列表，则记录
            if(!verifyBannedWord(word,banned)){
                if(wordCntMap.containsKey(word)){
                    wordCntMap.put(word,wordCntMap.get(word) + 1);
                }else {
                    wordCntMap.put(word,1);
                }
                if(wordCntMap.get(word) > maxCount){
                    retWord = word;
                }
                maxCount = Math.max(maxCount,wordCntMap.get(word));
            }
        }

        return retWord;
    }

    /**
     * 校验单词是否连带着标点符号
     */
    private static boolean notWithPunctuation(String word) {
        char lastChar = word.charAt(word.length()-1);
        return !((lastChar >= 'A' && lastChar <= 'Z')
                || (lastChar >= 'a' && lastChar <= 'z'));
    }

    /**
     * 校验word是否处于禁用单词列表中
     */
    private static boolean verifyBannedWord(String word,String[] banned) {
        for (String banStr : banned){
            if(banStr.equals(word)){
                return true;
            }
        }
        return false;
    }
}
