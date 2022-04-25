package com.wxp.algrithm.normalQuestion;

/**
 * @description: 二进制间距
 * @author: wxp
 * @time: 2022/4/24 21:49
 */
public class BinaryGap_868 {
    public static void main(String[] args) {
        System.out.println(binaryGap(5));
    }
    public static int binaryGap(int n) {
        String binStr = Integer.toBinaryString(n);

        //快慢指针计算最大间距
        int firstCursor = -1;
        int secCursor  = -1;
        int maxGab = 0;

        char[] charArr = binStr.toCharArray();

        for(int i =0; i < charArr.length ; i++){
            if(charArr[i] == '1'){
                //如果是第一个1,则记录
                if(firstCursor == -1){
                    firstCursor = i;
                }else{
                    //第二个和之后的1，需要将start前移，end等于之前的start
                    secCursor = firstCursor;
                    firstCursor = i;
                }
                if(secCursor != -1){
                    maxGab = Math.max(maxGab,firstCursor - secCursor);
                }
            }
        }
        return maxGab;
    }
}
