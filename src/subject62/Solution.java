package subject62;
/*
* 圆圈中最后剩下的数字【孩子们的游戏】
*
* 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
* HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
* 然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,
* 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
* 继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
* 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
*
* 本题就是著名的约瑟夫环问题
*
* 思路：
* 首先我们自己创建一个环形链表，然后再链表上操作
* */
class Node{
    int num;
    Node next = null;
    public Node(int num){
        this.num = num;
    }
}

public class Solution {

    Node firstNode = null;//定义链表的头结点
    Node temp = null;//定义链表指针

    //创建环形链表，n为链表的长度
    public void createLink(int n){
        for(int i = 0; i < n; i++){
            //处理首结点
            if(i == 0){
                Node nd = new Node(i);
                firstNode = nd;
                temp = firstNode;
            }else if(i == n-1){//处理尾结点
                Node nd = new Node(n-1);
                temp.next = nd;
                temp = nd;
                temp.next = firstNode;
            }else{
                Node nd = new Node(i);
                temp.next = nd;
                temp = nd;
            }
        }
    }

    //开始游戏
    public void play(int n, int m){
        temp = firstNode;//作为报数的起始点
        //报数，每次走掉一个孩子，只要孩子的个数大于1就一直报数
        while(n != 1){
            //报数，找到 m-1 的上一个节点
            for(int i = 1; i < m-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp = temp.next;
            n--;
        }
    }

}
