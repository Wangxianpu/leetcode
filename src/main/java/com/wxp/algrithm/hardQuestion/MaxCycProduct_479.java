package com.wxp.algrithm.hardQuestion;

/**
 * @description: 最大回文乘积
 *  给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 * @author: wxp
 * @time: 2022/4/16 15:44
 */
public class MaxCycProduct_479 {

    public static void main(String[] args) {
        //  1 <= n <= 8
        System.out.println(largestPalindrome(2));
    }

    /**
     * 从大到小构建回文，然后判断是否符合两个n位数相乘，符合则可以返回结果
     *  1、从大到小构建回文
     *  2、从大到小进行除余操作，如果能够整除，说明符合两数相乘。
     *  3、乘数的平方需要小于回文数
     *  4、因为，如果存在乘数的平方大于回文数并且能够被回文数整除，
     *  那么在从大到小的校验过程中肯定已经校验过了，相互矛盾
     * @param n n位数相乘
     */
    private static int largestPalindrome(int n) {
        //如果只是一位相乘数回文，则最大为9
        if(n == 1){
            return 9;
        }

        long  max = (long) (Math.pow(10,n) - 1);

        for(long i = max ; i > 0 ; i-- ){
            //构建回文数
            long palindrome = buildPalindrome(i);

            double sqrt =  Math.sqrt(palindrome);
            //判断是否能够整除
            for (long j = max; j > sqrt ; j--){
                if(palindrome % j == 0){
                    return (int) (palindrome % 1337);
                }
            }
        }
        return 0;
    }

    //根据当前值，构建回文数
    private static long buildPalindrome(long i) {
        StringBuilder sb = new StringBuilder(String.valueOf(i));
        return Long.parseLong((sb.toString()+ sb.reverse()));
    }

    /**
     * 暴力版判断，让你的电脑嗡嗡直叫！
     */
    public static int largestPalindrome2(int n) {
        long num = (long) Math.pow(10,n);
        long res = 0;
        for (long i = num - 1; i > 0 ; i--) {
            for (long j = i; j > 0 ; j--) {
                if(verifyIfCycNum(j) || verifyIfCycNum(i) ){
                    long product = i*j;
                    if(verifyIfCycNum(product)){
                        res = Math.max(res, product);

                    }
                }
            }
        }
        return (int) (res % 1337);
    }

    private static boolean verifyIfCycNum(long product) {
        String proStr = String.valueOf(product);
        int start = 0;
        int end = proStr.length() - 1;
        while(start < end){
            if(proStr.charAt(start) == proStr.charAt(end)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
}
