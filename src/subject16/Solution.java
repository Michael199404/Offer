package subject16;

import java.util.Scanner;

/*
* 数值的整数次方
*
* 题目描述：
* 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
*
* 思路：
* 主要是要考虑到各种情况
* 1. 当对数大于1的数的时候
* 2. 当对数等于1的时候，结果就是base本身
* 3. 当对数等于0的时候，res为1
* 4. 当对数小于0的时候，就要先对对数求绝对值，算出次方的结果然后求倒数
* */
public class Solution {
    public double Power(double base, int exponent) {
        double res = 1.0;
        //如果exponent是一个大于0的整数
        if(exponent >= 0){
            for(int i = 1; i <= exponent; i++){
                res = res * base;
            }
        }else{//如果指数是一个负数的时候，可以先对指数求绝对值，算出次方的结果以后再取倒数，这里求倒数的时候如果底数是0，也会报错
            int absoluteExponent = Math.abs(exponent);
            double temp = 1.0;
            if(base == 0)
                return 0;
            else{//如果底数不为0
                for(int i = 0; i < absoluteExponent; i++){
                    temp = temp * base;
                }
                res = 1 / temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            double base = scanner.nextDouble();
            int exponent = scanner.nextInt();
            double res = solution.Power(base, exponent);
            System.out.println(res);
        }
    }
}