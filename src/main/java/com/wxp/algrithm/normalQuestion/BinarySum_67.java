package com.wxp.algrithm.normalQuestion;

/**
 * @description:
 * @author: wxp
 * @time: 2022/4/4 19:32
 */
public class BinarySum_67 {

    public static String addBinary(String a, String b) {
        StringBuilder resultStr = new StringBuilder();

        String maxStr;
        String minStr;
        if(a.length() > b.length()){
            maxStr = a;
            minStr = b;
        }else {
            maxStr = b;
            minStr = a;
        }
        boolean isCarry = false;
        for (int i = maxStr.length() - 1 , j = 0; i >= 0 ; i--,j++) {
            //两数相加
            if(j <= minStr.length() - 1 ){
                //相加为3，进位
                if((minStr.charAt(minStr.length() - 1 - j) == '1' && maxStr.charAt(i) == '1') && isCarry){
                    isCarry = true;
                    resultStr.append("1");
                    continue;
                }
                //相加为2，进位
                if((minStr.charAt(minStr.length() - 1 - j) == '1' && maxStr.charAt(i) == '1') && !isCarry){
                    isCarry = true;
                    resultStr.append("0");
                    continue;
                }
                //相加为2，进位
                if((isCarry && (minStr.charAt(minStr.length() - 1 - j) == '1' ||  maxStr.charAt(i) == '1'))){
                    isCarry = true;
                    resultStr.append("0");
                    continue;
                }
                //相加为1，不进位
                if((isCarry && minStr.charAt(minStr.length() - 1 - j) == '0' &&  maxStr.charAt(i) == '0')
                    || (!isCarry && (minStr.charAt(minStr.length() -1 - j) == '1' ||  maxStr.charAt(i) == '1'))){
                    isCarry = false;
                    resultStr.append("1");
                    continue;
                }
                //相加为0，不进位
                isCarry = false;
                resultStr.append("0");
                continue;
            }

            //进位自增
            if(maxStr.charAt(i) == '1' && isCarry){
                isCarry = true;
                resultStr.append("0");
            }else if(isCarry && maxStr.charAt(i) == '0'){
                isCarry = false;
                resultStr.append("1");
            }else {
                isCarry = false;
                resultStr.append(maxStr.charAt(i));
            }
        }

        if (isCarry){
            resultStr.append("1");
        }
        return resultStr.reverse().toString();
//        String tmpStr = resultStr.toString();
//        char[] chars = tmpStr.toCharArray();
//        StringBuffer retStr = new StringBuffer()
//        for (char c: chars) {
//            
//        }
        
    }
    public static void main(String[] args) {
        /**
         * "101111"
         * "10"
         */
        System.out.println(addBinary("101111","10"));
    }

    private static String addBinary2(String s, String s1) {
        int num1 = Integer.parseInt(s,2);
        int num2 = Integer.parseInt(s1,2);
        return Integer.toBinaryString(num1+num2);
    }

}
