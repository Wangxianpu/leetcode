package com.wxp.binSplit;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/6/19 19:32
 * @Description : Pow(x, n)
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2.00000 ,-2147483648));
    }

    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        int sign = 0;
        //如果是负数，则转成正数进行处理
        if(n<0){
            x = 1/x;
            if(n == Integer.MIN_VALUE){
                n+=2;
            }
            n = -n;
        }
        double result = myPow(x,n/2);
        if(n%2 == 0){
            return  result*result;
        }else{
            return result*result*x;
        }
    }
}
