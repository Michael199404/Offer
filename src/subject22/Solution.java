package subject22;

/*
* 链表中倒数第k个结点
*
* 思路:
* 1.定义两个指针，第一个指针从头开始先走k-1步，第二个指针保持不动
* 2.之后两个指针同时走，当第一个指针走到链表尾部的时候，第二个指针就使倒数第k个结点
* 3.注意代码的鲁棒性
*   3.1判断k是否大于链表的总长度
*   3.2头指针是否为空
*   3.3输入的参数k小于1
* */

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

public class Solution {
    public ListNode FindKthToTail(ListNode head, int k){
        if(head == null || k <= 0)
            return null;

        ListNode first = head;
        ListNode second = head;

        //先让first走k-1步,如果first指向了null，说明k的长度大于链表的长度
        for (int i = 0; i < k-1; i++) {
            if(first != null){
                first = first.next;
            }else{
                return null;
            }
        }

        //让second和first一起走，直到first.next为空
        while(first.next != null){
            second = second.next;
            first = first.next;
        }
        return second;
    }
}
