package subject51;
/*
* 数组中的逆序对
* */
/*
思路：利用归并排序算法的思想，边排序边统计
*/
public class Solution {

    int count = 0;

    public int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return -1;
        }
        mergeSort(array, 0, array.length-1);
        return count;
    }

    public void mergeSort(int[] a, int left, int right){
        if(left < right){
            int mid = (left + right) >> 1;
            mergeSort(a, left, mid);
            mergeSort(a, mid+1, right);
            merge(a, left, mid, right);
        }
    }

    //合并函数，合并的时候统计逆序对的个数
    public void merge(int[] a, int left, int mid, int right){
        int[] temp = new int[right-left+1];//辅助数组
        int t = right - left;
        int l = mid;
        int r = right;

        while(l >= left && r >= mid+1){
            if(a[l] > a[r]){
                count += (r-mid);
                temp[t--] = a[l--];
                if(count >= 1000000007){
                    count %= 1000000007;
                }
            }else{
                temp[t--] = a[r--];
            }
        }
        while(l >= left){
            temp[t--] = a[l--];
        }
        while(r >= mid+1){
            temp[t--] = a[r--];
        }
        for(int i = 0; i <= right-left; i++){
            a[left+i] = temp[i];
        }
    }
}
