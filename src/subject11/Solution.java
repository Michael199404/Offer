package subject11;
/*
* 思路：
* 1.数组旋转后总可以划分为两个排序子数组，所以可以利用二分法去查找出数组中的最小值
* 2.我们可以找到数组的中间元素
*   2.1 如果中间元素大于l指向的元素，说明最小元素位于中间元素的后边
*   2.3 如果中间元素小于l指向的元素，说明最小元素位于中间元素的前边
* 3.旋转数组中第一个数字一般会大于最后一个数字，但是如果我们把前边0个元素搬到
* 后边，也就是当第一个数字小于最后边那个数字的时候可以直接返回第一个数字。
* 4.如果出现重复数字，导致l、r和中间指向的数字都相同，这种情况我们只能用顺序查找的办法来找到最小数
* */
public class Solution {

    public static int minNumberInRotateArray(int[] array){

       if(array == null || array.length == 0)
           return 0;

       int l = 0;
       int r = array.length-1;
       int m = 0;
       int min = 0;

       if(array[0] <= array[array.length-1])
           return array[0];

       //如果数组
       while(l <= r){

           if(r - l == 1){
               array[min] = array[r];
               break;
           }

           m = (l + r) / 2;

           //如果下标l、r和m指向的数字相同，则只能顺序查找
           if(array[l] == array[r] && array[l] == array[m]){
               return minInOrder(array, l, r);
           }

           if(array[m] >= array[l]){
               l = m;//因为元素可能有重复
           }else if(array[m] <= array[l]){
               r = m;//因为元素可能有重复
           }
       }

       return min;
    }

    public static int minInOrder(int[] arr, int l, int r){
        int min = arr[l];
        for (int i = l+1; i <= r; i++) {
            if(min > arr[i])
                min = arr[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int res = minNumberInRotateArray(array);
        System.out.println(res);
    }
}
