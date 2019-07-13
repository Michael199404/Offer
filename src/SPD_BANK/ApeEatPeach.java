package SPD_BANK;
/*
* 猴子吃桃问题
*
*猴子吃桃子问题：猴子第一天摘下N个桃子，当时就吃了一半，还不过瘾，就又吃了一个。第二天又将剩下的桃子吃掉一半，
*又多吃了一个。以后每天都吃前一天剩下的一半零一个。
*到第10天在想吃的时候就剩一个桃子了,求第一天共摘下来多少个桃子？
* */

public class ApeEatPeach {
    public static void main(String[] args){
        int n = 1;//第十天剩下的桃子的个数
        for(int i = 0; i < 6; i++){
            n = (n + 1 ) * 2;
        }
        System.out.println(n);
    }
}
