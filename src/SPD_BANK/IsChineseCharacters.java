package SPD_BANK;
/*
* 输入一段话，输出字的个数
*
* 思路：
* 使用正则表达式，中文汉字字符编码范围：[\u4e00-\u9fa5]
* */
import java.util.Scanner;

public class IsChineseCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            char[] chars = scanner.nextLine().toCharArray();
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if(String.valueOf(chars[i]).matches("[\\u4E00-\\u9FA5]")){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
