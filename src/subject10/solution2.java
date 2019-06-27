package subject10;
/*
* 题目描述：
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
*
* 思路：
* 斐波那契数列的应用
* f(n)=1 n=1
* f(n)=2 n=2
* f(n)=f(n-1)+f(n-2) n>2
* */
public class solution2 {
    public int JumpFloor(int target){
        //如果只有一级台阶，则只有一种跳法
        if(target == 1)
            return 1;
        //如果有两级台阶，则有两种跳法
        if(target == 2)
            return 2;
        /*
        * 如果有超过两级的台阶，则如果第一次只跳了一级台阶，那么
        * 此时的跳法数目等于后面n-1级台阶的跳法数目；如果第一次跳了
        * 两级台阶，那么此时的跳法数目等于后面n-2级台阶的跳法数目
        */
        int a = 1;
        int b = 2;
        int c = 0;
        if(target > 2){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
