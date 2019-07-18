package subject58;
/*
* 左旋转字符串
*
* 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
* 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
* 要求输出循环左移3位后的结果，
* 即“XYZdefabc”。是不是很简单？OK，搞定它！
* */
/*
思路：
1.abcdefg 我们可以把它分为两个部分，ab和cdefg。
2.由于想把前边的两个字母移动到后边，相当于交换ab和cdefg两个单词的顺序
3.这样，我们就可以先翻转ab和cdefg，然后在整体翻转
*/
public class Solution2 {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0)
            return str;
        char[] chars = str.toCharArray();
        //首先翻转前n个字符
        reverse(chars, 0, n-1);
        //翻转剩下的字符
        reverse(chars, n, chars.length-1);
        //翻转整个字符串
        reverse(chars, 0, chars.length-1);
        String res = new String(chars);
        return res;
    }

    //将一个字符串数组翻转
    public void reverse(char[] chars, int l, int r){
        if(chars == null || chars.length < 1)
            return;
        while(l < r){
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}
