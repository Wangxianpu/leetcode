package com.wxp.binSplit;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/6/15 18:14
 * @Description : 判断输入的一个数是否是2的幂次方
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.print(new PowerOfTwo().mySqrt(2147483647));
    }


    private boolean isBig(long x ,long y){
        return (long)x*x <= y;
    }

    //注意区间的问题，[)
    public int mySqrt(int x) {
        long left = 0;
        long right = (long)x+1;//这里将y+1，可以避免漏的问题[0,y)
        long result = 0;
        while(left < right){
            long temp = (left+right)/2;
            if(isBig(temp,x)){
                left = temp+1;
                result = temp;
            }else{
                right = temp;
            }
        }
        return (int)result;
    }
}
