package subject58;
/*
* 翻转单词顺序列
*
* 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
* 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
* 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
* 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
*
* 思路：利用双指针法
* */
public class Solution1 {
    public String ReverseSentence(String str) {
        if(str == null || str.trim().length() == 0)
            return str;

        //将字符串以空格为间隔转化为字符串数组
        String[] strings = str.split(" ");

        //逆序这个数组
        int l = 0;
        int r = strings.length-1;
        while(l < r){
            String temp = strings[l];
            strings[l] = strings[r];
            strings[r] = temp;
            l++;
            r--;
        }

        //将字符串数组转化为字符串
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strings.length-1; i++){
            sb.append(strings[i]).append(" ");
        }
        sb.append(strings[strings.length-1]);
        String res = sb.toString();
        return res;
    }
}
