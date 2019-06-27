package subject10;
/*
* 题目描述：
* 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
*
* 思路：
* f(n)=0 n=0
* f(n)=1 n=1
* f(n)=f(n-1)+f(n-2) n>1
*
* 如果直接使用递归，会造成计算量的急剧增大，计算大量的重复值。
* 所以，这里我们使用动态规划来解题，把刚刚计算过的结果保存下来，留作计算后边
* 的数的时候使用。
*
* 我们从最小的那个数开始计算，用a和b保存前两项的结果，直接用a+b得出下一个数的结果
* */
public class Solution1 {
    public int Fibonacci(int n) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;

        int a = 0;//初始化a为第一项
        int b = 1;//初始化b为第二项
        int c = 0;
        if(n > 1){
            for(int i = 0; i < n-1; i++){
                c = a + b;
                a = b;
                b = c;
            }
        }
        return c;
    }
}
