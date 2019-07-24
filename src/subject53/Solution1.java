package subject53;
/*
* 统计一个数字在排序数组中出现的次数。
* */
/*
思路：
因为是统计一个数字在排序数组中出现的次数
所以可以使用二分查找法去查找这个数字
总体思路是找到数组中的第一个k的位置和最后一个k的位置
 二分查找总是拿数组中间的那个数字和k作比较，如果中间的那个数字比k大，说明k只出现在数组的
 前半段；如果中间的数字比k小，说明k只出现在数组的后半段
 如果中间的那个数字等于k，我们首先判断这个数字是不是第一个k，如果中间
 数字的前面一个数字不是k，那么说明这个k就是第一个k
 如果中间数字的前一个数也是k，说明第一个k肯定出现在数组的前半段

 利用同样的思路去找最后一个k的位置
 如果中间的数字等于k，首先判断k后边的那个数字是不是也为k，如果
 不为k，说明中间这个数字就是最后一个k；如果下一个数字还是k，说明
 最后一个k出现在数组的后半段

 利用递归思路去找到第一个k和最后一个k的位置
*/
public class Solution1 {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        if(array == null || array.length == 0){
            return 0;
        }

        int first = GetFirstK(array, k);
        int last = GetLastK(array, k);

        if(first != -1 && last != -1){
            return last - first + 1;
        }

        return 0;

    }

    //找到数组中第一个k的位置
    public int GetFirstK(int[] array, int k){
        int l = 0;
        int r = array.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            //如果中间的这个数字是k，则查看这个数前边的那个数是不是k
            if(array[mid] == k){
                //如果前边的那个数不是k，则说明中间这个k就是数组中出现的第一个k
                if(mid > 0 && array[mid-1] != k || mid == 0){
                    return mid;
                }else{//如果前边那个数也是k，说明第一个k出现在数组的前半段
                    r = mid - 1;
                }
            }else if(array[mid] > k){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }

    //找到数组中最后一个k的位置
    public int GetLastK(int[] array, int k){
        int l = 0;
        int r = array.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(array[mid] == k){
                //判断后一个数字是不是k， 如果后一个数字不为k，则说明这个k就是最后一个k
                //如果中间的下一个不为k，或者最后一个为k，说明mid指向的就是最后一个k
                if(mid < array.length - 1 && array[mid+1] != k || mid == array.length - 1){
                    return mid;
                }else{//如果中间下一个为k，或者如果mid指向最后一个位置时不为k，说明mid指向的不是最后一个k，说明最后一个k在mid的后边
                    l = mid + 1;
                }
            }else if(array[mid] > k){//说明最后一个k出现在数组前半段
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
