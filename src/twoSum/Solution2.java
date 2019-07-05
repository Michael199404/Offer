package twoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
思路：
三指针法
1.首先将数组排序
2.定义三个指针i，j和k
3.首先固定i，让j和k移动，如果三个指针指向的数字的和大于0，k向左移动，否则j向右移动
4.将符合的组合添加到list当中
5.需要考虑的是出现大量重复的元素的时候如何降低发杂度（直接跳过）
*/
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();//存放最后的结果

        if(nums == null || nums.length < 3){
            return res;
        }


        //对数组进行排序
        Arrays.sort(nums);

        //定义三个指针(初始化三个指针的位置)
        int i = 0;
        int j = 1;
        int k = nums.length-1;

        //开始循环查找符合的三元组
        for(i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            j = i + 1;
            k = nums.length - 1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){//如果sum=0，就将结果保存到list当中
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                    //为了避免出现重复的三元组
                    while(nums[j-1]==nums[j] && j<k){
                        j++;
                    }
                    while(nums[k+1]==nums[k] && j<k){
                        k--;
                    }
                }else if(sum > 0){//如果sum>0,则k--
                    k--;
                    while(nums[k+1] == nums[k] && j<k){
                        k--;
                    }
                }else{//如果sum<0
                    j++;
                    while(nums[j-1] == nums[j] && j<k){
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
