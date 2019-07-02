package subject17;
/*
* 打印从1到最大的n位数
*
* 题目描述：
* 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出
* 1、2、3一直到最大的3位数999。
*
* 我们注意到面试官没有规定n的范围，当输入的n很大的时候，int或者long是否会
* 溢出？
*
* 思路：
* 用最简单的方法实现
*
* */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.print1ToMaxOfDigits(3);
    }

    public void print1ToMaxOfDigits(int n){

        if(n < 0)
            return;

        //long基本类型，64位
        long number = 1;
        int i = 0;
        //利用while循环计算出比n位十进制多1的数
        while(i < n){
            number = number * 10;
            ++i;
        }

        //打印
        for (long j = 0; j < number; j++) {
            System.out.print(j + " ");
            if(j % 5 == 0)
                System.out.println();
        }
    }
}
