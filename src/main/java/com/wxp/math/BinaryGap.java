package com.wxp.math;

/**
 * Created by 10521 on 2018/9/21.  二进制间距
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int[] ans = new int[32];
        int tmp = 0;
        int i = 0;
        int max = 0;

        //记录各个位数上是否为1
        while(N > 0){
            i++;
            if(N % 2 == 1){
                ans[tmp] = i;
                tmp++;
            }
            N /= 2;
        }

        for(int j = 1 ; j < tmp; j++){
            if((ans[j]-ans[j-1]) > max){
                max = ans[j] - ans[j-1];
            }
        }
        return max;
    }

}
