package subject17;

import java.sql.SQLOutput;

/*
* 思路：
* 1.为了解决溢出问题，我们使用字符串模拟加法
* 2.如何用字符串模拟加法？
* 3.在字符串表达数字上模拟加法，我们首先设置是否溢出标识，是否进位标识，以及取得字符数组长度，
* 遍历这个字符数组，在末尾进行+1操作，如果末尾字符在+1后变为不小于10的数字，
* 我们将末尾减去10加上‘0’字符赋值为末位，进位标识设置为1，在循环次位时+1，
* 然后再判断是否为不小于10，是的话重复上面的步骤。直到判断高位是不是不小于10，
* 是的话字符数组溢出；如果末尾字符在+1后是小于10的数字，直接加上‘0’赋值给末尾，
* 跳出当前循环，返回没有溢出。
* */
public class Solution2 {

    //测试
    public static void main(String[] args) {
        print1ToMaxOfDigits(4);
    }

    public static void print1ToMaxOfDigits(int n){
        if(n <= 0)
            return;

        //创建一个字符串对象
        StringBuffer number = new StringBuffer();

        //初始化放入的字符
        for (int i = 0; i < n; i++) {
            number.append('0');
        }

        while(!increment(number)){
            printNumber(number);
        }
    }

    //判断是不是已经到达了最大的n位数
    private static boolean increment(StringBuffer number){
        boolean isOverFlow = false;//判断是否溢出
        int nTakeOver = 0;//判断是否进位
        int nLength = number.length();
        //在字符串上模拟加1操作，因为有进位，所以要对每一位进行循环
        for (int i = nLength-1; i >= 0; i--) {
            int nSum = number.charAt(i) - '0' + nTakeOver;//当前值
            //只有是个位时，数值加1
            if(i == nLength-1){
                nSum++;
            }
            //满10进1
            if(nSum >= 10){
                if(i == 0){
                    //超过n位了
                    isOverFlow = true;
                }else{
                    nSum = nSum - 10;
                    nTakeOver = 1;
                    number.setCharAt(i, (char)('0'+nSum));
                }
            }else{//如果这一位不满10
                number.setCharAt(i, (char)('0'+nSum));
                break;
            }
        }
        return isOverFlow;
    }

    //打印字符串,找到第一位不为‘0’的字符，从这个不为‘0’的字符开始打印
    public static void printNumber(StringBuffer number){
        boolean isBeginAtZero = true;
        for (int i = 0; i < number.length(); i++) {
            if(isBeginAtZero && number.charAt(i)!='0'){
                isBeginAtZero = false;
            }
            if (!isBeginAtZero){
                System.out.print(number.charAt(i));
            }
        }
        System.out.println();
    }
}
