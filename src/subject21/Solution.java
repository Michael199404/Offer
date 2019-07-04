package subject21;
/*
* 调整数组顺序使奇数位于偶数前面
*
* 思路：
* 1.使用两个指针，第一个指针指向第一个数字，第二个指针指向最后一个数字
* 2.向后移动第一个指针直到它指向偶数，移动第二个指针直到指向奇数
* 3.交换两个指针指向的元素
* 4.直到两指针相遇
* */
public class Solution {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        reOrderArray(array);
        for (int i = 0; i < 5; i++) {
            System.out.println(array[i]);
        }
    }

    public static void reOrderArray(int[] array){
        if(array == null || array.length == 0)
            return;

        int l = 0;
        int r = array.length-1;

        while(l < r){
            //向后移动l直到指向偶数
            while(l < r && (array[l]%2) != 0){
                l++;
            }
            //向前移动r直到指向奇数
            while(l < r && (array[r]%2) == 0){
                r--;
            }
            //如果l<r,则交换l和r指向元素的位置
            if(l < r){
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }
    }
}
