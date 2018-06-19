package com.wxp.binSplit;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/6/19 14:56
 * @Description : 有序矩阵中第K小的元素
 * 解题思路：
 *  需要进行两次二分，首先二分获取值，然后遍历二分计算出小于该元素的值的数量。
 *  并不是根据k来查找对应的值。而是二分值来匹配对应的k，无限趋近，最后取值
 */

public class KthSmallest {



    //使用二分的原因是因为，k越大，返回的值越大，而且存在一定的顺序关系，行列都是递增
    public int kthSmallest(int[][] matrix, int k) {
        //第一次二分获取值，也是需要返回的值
        int L = matrix[0][0];
        int R = matrix[matrix.length-1][matrix.length-1]; //[L,R] 闭区间，因此[a,a]是有意义的
        int ans = 0;
        while(L <= R){
            int mid = (int) (((long)L+R)/2);
            if(guess(matrix,k,mid)){
                ans = mid;
                L = mid +1;
            }else {
                R = mid -1;//如果这里不 -1 ,那么二分到后面[a,a]循环会结束不了的
            }
        }
        return ans;
    }

    private boolean guess(int[][] matrix, int k, int g) {
        int sum = 0;
        for(int i = 0; i < matrix.length ; i++){
            int L = 0;
            int R = matrix.length -1;
            int ans = -1;
            while(L <= R){
                int mid = (int) (((long)L+R)/2);
                if(matrix[i][mid] < g){
                    ans = mid ;
                    L = mid + 1;
                }else{
                    R = mid - 1;
                }
            }
            sum += (ans+1);
        }
        return k > sum;
    }

}
