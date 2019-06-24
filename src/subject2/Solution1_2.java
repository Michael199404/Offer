package subject2;
/*
* 思路：
* 这里使用集合来解决
* 向集合中添加数组中的元素，如果判断这个元素已经存在，我们就返回true，
* 并且将这个值记录下来
* */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution1_2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int n = scan.nextInt();
            int[] numbers = new int[n];
            int[] duplicate = new int[1];
            for (int i = 0; i < n; i++) {
                numbers[i] = scan.nextInt();
            }
            boolean res = duplicate(numbers, n, duplicate);
            System.out.println(res + " " + duplicate[0]);
        }
    }

    public static boolean duplicate(int[] numbers, int length, int[] duplication){
        if(numbers == null || length == 0){
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            if(set.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }else{
                set.add(numbers[i]);
            }
        }
        return false;
    }
}
