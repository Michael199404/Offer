package subject5;
/*
* 题目描述：
* 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为 We%20Are%20Happy。
*
* 思路一（O(n^2)）：
* 1.首先遍历字符串，得到空格的个数以及字符串的长度
* 2.建立一个新的字符数组，这个新的数组的长度就是空格被替换之后的长度，复制字符到这个新的字符数组
* 3.每次碰到一个空格，就把一个字符替换成三个字符
* */
public class Solution {

    public String replaceSpace(StringBuffer str){
        if(str == null){
            return null;
        }

        //定义空格的个数
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                spaceNum++;
            }
        }

        //定义两个指针
        int indexOld = str.length() - 1;
        int indexNew = str.length() + spaceNum*2 - 1;

        return str.toString();
    }
}
