package subject14;
/*
* 剪绳子：利用动态规划
*
* 题目描述：
* 给你一根长度为n的绳子，请把绳子剪成m段（m，n都是大于1 的整数）。每段绳子长度的可能最大乘积是多少。
*
* http://www.manongjc.com/article/37973.html
* */
public class Solution1 {
    public int cutting(int len){
        if(len < 2)
            return 0;
        if(len == 2)
            return 1;
        if(len == 3)
            return 2;

        //存储长度为0-len的最大结果
        int[] result = new int[len+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        //自底向上开始求解
        int max = 0;
        for (int i = 4; i <= len; i++) { //最外层i表示长度为i的绳子
            max = 0;
            //这层循环用来计算长度为i的绳子剪成若干段之后各段长度乘积的最大值
            for (int j = 1; j <= i/2; j++){
                int tempResult = result[j] * result[i-j];
                if(max < tempResult)
                    max = tempResult;
                result[i] = max;
            }
        }
        max = result[len];
        return max;
    }
}
