package subject15;

import java.util.Scanner;

/*
* 二进制中1的个数
*
* 题目描述：
* 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
* */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int res = NumberOf1(n);
        System.out.println(res);
    }

    public static int NumberOf1(int n) {
        //使用flag与n做与运算
        int flag = 1;
        int count = 0;

        while(flag != 0){
            if((flag&n) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}