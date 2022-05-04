package com.wxp.algrithm.normalMid;

/**
 * @description: 每日一题 1823 -》找出游戏的获胜者
 *  共有 n 名小伙伴一起做游戏。小伙伴们围成一圈，按 顺时针顺序 从 1 到 n 编号。确切地说，
 *  从第 i 名小伙伴顺时针移动一位会到达第 (i+1) 名小伙伴的位置，其中 1 <= i < n ，
 *  从第 n 名小伙伴顺时针移动一位会回到第 1 名小伙伴的位置。
 *
 * 游戏遵循如下规则：
 *
 * 从第 1 名小伙伴所在位置 开始 。
 * 沿着顺时针方向数 k 名小伙伴，计数时需要 包含 起始时的那位小伙伴。逐个绕圈进行计数，一些小伙伴可能会被数过不止一次。
 * 你数到的最后一名小伙伴需要离开圈子，并视作输掉游戏。
 * 如果圈子中仍然有不止一名小伙伴，从刚刚输掉的小伙伴的 顺时针下一位 小伙伴 开始，回到步骤 2 继续执行。
 * 否则，圈子中最后一名小伙伴赢得游戏。
 * @author: wxp
 * @time: 2022/5/4 15:32
 */
public class FindTheWinner_1823 {

    public static void main(String[] args) {
        System.out.println(findTheWinner(6, 5));
    }

    public static int findTheWinner(int n, int k) {
        if(n == 0 || k == 0){
            return 0;
        }
        int[] nums = new int[n];

        //出局人数
        int out = 0;
        //标记当前计数下标
        int curIndex = -1;
        //当出局人数小于n-1时，继续游戏
        while(out < n - 1){
            int cursor = 0;

            while(cursor < k){
                //如果当前角色没有淘汰，则计数
                if(nums[(++curIndex) % n] == 0 ){
                    cursor++;
                }
            }
            //如果计数标记在已经被淘汰的角色上，则指针继续后移
            while(nums[curIndex % n] == -1){
                curIndex++;
            }
            //淘汰
            nums[curIndex % n] = -1;
            out++;
        }

        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == 0){
                return i+1;
            }
        }
        return 0;
    }
}
