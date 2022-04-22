package com.wxp.algrithm.normalQuestion;

/**
 * @description: 山羊拉丁文
 * @author: wxp
 * @time: 2022/4/21 22:34
 */
public class ToGoatLatin_824 {
    public static void main(String[] args) {
        String sentence = "I speak Goat Latin";
        System.out.println(toGoatLatin(sentence));
    }

    public static String toGoatLatin(String sentence) {
        if(null == sentence || "".equals(sentence)){
            return "";
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < words.length ; i++){
            //如果是元音开头
            if(startWithVowel(words[i])){
                sb.append(words[i]).append("ma");
            }else {
                //如果是辅音字母开头
                char c = words[i].charAt(0);
                sb.append(words[i].substring(1)).append(c).append("ma");
            }
//            sb.append("a".repeat(i + 1));
            sb.append(" ");
        }
        return sb.substring(0,sb.length()-1);
    }

    private static boolean startWithVowel(String word) {
        char c = word.charAt(0);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
