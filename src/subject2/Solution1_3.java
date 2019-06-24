package subject2;
/*
* 思路：
* 因为这n个数字是在0~n-1的范围内，所以如果没有重复数字的话，
* 每个数字的下标和当前这个数字是一样的。
* 我们把每个数字放到它应该在的位置上，
* 从第一个数字开始，我们看这个数字是不是等于它的下标，如果不是，就将这个数字
* 放到下标等于这个数字的地方
* 在放的时候，判断和它交换的这个数字是不是和它相等，如果相等则说明重复
* */

public class Solution1_3 {
    public static void main(String[] args) {
        int[] a = {2,3,1,0,2,5,3};
        int[] duplicate = new int[1];
        boolean res = duplicate(a, 7, duplicate);
        System.out.println(res + " " + duplicate[0]);
    }

    public static boolean duplicate(int[] numbers, int length, int[] duplication){
        if(numbers == null || length == 0){
            return false;
        }

        for (int i = 0; i < length; i++){
            if(numbers[i] != i){ //如果当前数字和下标不相等i，则将这个数字放到它该有的地方
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }//如果不相等，则交换
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;

            }
        }

        return false;
    }
}
