package subject63;

import java.util.Scanner;

/*
* 股票的最大利润
*
* 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股票可能获得的利润是多少？
* 例如一只股票在某些时间节点的价格为{9, 11, 8, 5,7, 12, 16, 14}。
* 如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11。
*
* 思路：
* 1.股票只有买入之后才能卖出，因此，股票的最大利润就是数组中所有的数对的最大差值。
* 2.遍历过程中记录最小值min，然后计算当前值与最小值的差值diff，并更新maxDiff
* */
public class Solution {

    public static int maxDiff(int[] arr){
        if(arr == null || arr.length < 2){
            return -1;
        }

        //最大利润可以是负数，只要亏损最小就可以了
        int min = arr[0];//最小值
        int maxDiff = arr[1] - arr[0];//当前卖出时的最大差值

        if(arr.length == 2){
            return maxDiff;
        }

        for(int i = 2; i < arr.length; i++){
            if(arr[i-1] < min)
                min = arr[i-1];
            int curDiff = arr[i] - min;
            if(curDiff > maxDiff)
                maxDiff = curDiff;
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] price = new int[]{9,11,8,5,7,12,14,16};
        int res = maxDiff(price);
        System.out.println(res);
    }
}
