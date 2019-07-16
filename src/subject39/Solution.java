package subject39;

/*
数组中出现次数超过一半的数字

思路：
1. 如果一个数组中的一个数字出现的次数超过数组长度的一半，那么如果将这个数组排序，这个数组的中位数一定
就是长度超过一半的数字。我们知道，对于中位数来说，他左边的数都比它小，它右边的数都比它大。看到这里，
我们想到了快速排序中的Partition函数，首先随机选择一个数，把小于这个数的所有数字放到这个数的左边，大于
这个数的所有数字放到它的右边。
2. 结合前面的分析，如果这个数字的下标正好是n/2,说明它就是我们要找的那个数；如果这个数的下标小于n/2，我们就到
这个数的右边去找，如果大于n/2,我们就到这个数的左边去找。
3. 大的问题的解决需要小的问题的解决，而且解决的思路一样，所以这里使用递归的思路去解这道题。
*/
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        //判断输入的数组是不是无效的
        if(checkInvalidArray(array))
            return 0;

        int middle = array.length >> 1;//定义中位数的位置
        int start = 0;//定义需要查找的起始位置
        int end = array.length - 1;//定义查找的终止位置
        int index = partition(array, start, end);//定义调整位置后返回的位置

        //1. 寻找中位数
        while(index != middle){
            //如果返回的位置小于middle，则到index的右边去找
            if(index < middle){
                start = index + 1;
                index = partition(array, start, end);
            }else{//如果返回的位置大于middle，则到index的左边去找
                end = index - 1;
                index = partition(array, start, end);
            }
        }

        boolean moreThanHalf = checkMoreThanHalf(array, array[index]);
        if(arrayInvalid)
            return 0;

        int result = array[index];

        return result;
    }

    //检查是否为无效数组
    boolean arrayInvalid = false;
    public boolean checkInvalidArray(int[] array){
        if(array == null || array.length == 0){
            arrayInvalid = true;
        }
        return arrayInvalid;
    }

    //检查中位数是否位次数最多的元素
    public boolean checkMoreThanHalf(int[] array, int number){
        int times = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == number){
                times++;
            }
        }
        boolean isMoreThanHalf = true;
        if(times*2 <= array.length){
            arrayInvalid = true;//为无效数组
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }

    public int partition(int[] array, int low, int high){
        int i = low;
        int j = high;
        int pivot = array[low];

        while(i < j){
            //向左扫描
            while(i < j && array[j] > pivot)
                j--;
            if(i < j){
                swap(array, i++, j);
            }

            //向右扫描
            while(i < j && array[i] <= pivot)
                i++;
            if(i < j){
                swap(array, i, j--);
            }
        }
        return j;
    }

    //交换数组中两个元素的位置
    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}