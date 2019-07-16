package Netease;
/*
* 代价
*
* 你有3个需要完成的任务，完成这3个任务是需要付出代价的。
首先，你可以不花任何代价的完成一个任务；然后，在完成了第i个任务之后，你可以花费|Ai - Aj|的代价完成第j个任务。|x|代表x的绝对值。
计算出完成所有任务的最小代价。

输入描述:
一行3个整数A1,A2,A3，每个数字之间用一个空格分隔。所有数字都是整数，并且在[1,100]范围内。

输出描述:
一个整数，代表最小的代价。

输入例子1:
1 6 3

输出例子1:
5

输入例子2:
10 10 10

输出例子2:
0
* */
import java.util.Scanner;

public class Price {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        while(scanner.hasNextInt()){
            for(int i = 0; i < 3; i++){
                arr[i] = scanner.nextInt();
            }
            //求出任意两个数之间的差值
            int a = Math.abs(arr[1] - arr[0]);
            int b = Math.abs(arr[2] - arr[0]);
            int c = Math.abs(arr[2] - arr[1]);
            //计算得到最小的代价
            if(a <= c && b <= c){
                System.out.print(a+b);
            }else if(a <= b && c <= b){
                System.out.print(a+c);
            }else{
                System.out.print(b+c);
            }
        }
    }
}
