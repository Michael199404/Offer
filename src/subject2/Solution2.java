package subject2;
/*
* 思路一：
* 数组长度为n+1，数字是从1到n，那么说明必定有重复元素。
* 最简单的解题方法是使用一个n+1的辅助数组，将原数组向辅助数组中复制，
* 复制到数字和下标相同的位置，如果发现数组中已经有了复制的这个数，则
* 说明这个数是重复的数
* 思路二：
* 使用二分法，这样的优点是可以不使用辅助空间
* 1.将数组划分为1~m和m+1到n
* 2.判断1~m中数组的个数是多少m，则说明重复数字在这一半区间内
* 3.我们继续在这个区间内划分，直到找到重复的数字
* */
public class Solution2 {
    public static void main(String[] args) {

    }

    public int getDuplicate(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }

        //检查数组是否超出范围(1~arr.length-1)
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 1 || arr[i] > arr.length-1){
                return -1;
            }
        }

        //使用二分法找出重复的数字
        int low = 1;
        int high = arr.length-1;
        int mid;
        int count;
        while(low <= high){
            mid = (low+high) / 2;
            count = countRange(arr, low, mid);//最后一次count记录的是重复的那个数字出现的次数
            if(low == high){
                if(count > 1){
                    return low;
                }else{
                    break;
                }
            }
            if(count > mid-low+1){
                high = mid;
            }else{
                low = mid + 1;
            }
        }


        return 0;
    }

    //得到数组arr中，范围在low和high之间的数字的个数
    public int countRange(int[] arr, int low, int high){
        if(arr == null)
            return 0;
        int count = 0;
        for (int a : arr) {
            if(a >= low && a <= high){
                count++;
            }
        }
        return count;
    }

}
