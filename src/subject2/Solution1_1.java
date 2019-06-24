package subject2;

import java.util.Arrays;

/*
* 思路：
* 最简单的方法是对数组进行排序，之后找出
* */
public class Solution1_1 {

    public static void main(String[] args) {
        int[] a = {2,4,3,1,4};
        int[] b = new int[1];
        boolean res = duplicate(a, 5, b);
        System.out.println(res + " " + b[0]);
    }

    public static boolean duplicate(int[] numbers, int length, int[] duplication){
        if(numbers == null || length == 0)
            return false;
        Arrays.sort(numbers);
        //遍历找出第一个重复的数字
        for (int i = 0; i < length-1; i++) {
            //这里要注意，不能写成numbers[i] == numbers[++]
            //因为++i表示i加上1然后赋值给i，这里就改变了i的值，影响到了循环
            if(numbers[i] == numbers[i+1]){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

}
