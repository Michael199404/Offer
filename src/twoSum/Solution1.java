package twoSum;

import java.util.HashMap;
import java.util.Map;

/*
* 两数之和
* 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那
* 两个整数，并返回他们的数组下标。
*
* 思路：
*
* */
public class Solution1 {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        return null;
    }
}
