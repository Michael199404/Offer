package subject52;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/*
思路：
因为是单链表，所以在公共节点重合了以后就不会再分开
我们可以定义两个指针，先让链表长的那个先走长度差步，
然后两个链表一起走，边走边比较，找到第一个相同的节点返回
*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;

        //分别计算两个链表的长度
        int len1 = count(pHead1);
        int len2 = count(pHead2);
        int diff = Math.abs(len1 - len2);

        //让长的链表先走diff步
        if(len1 > len2){
            for(int i = 0; i < diff; i++){
                pHead1 = pHead1.next;
            }
        }
        if(len2 > len1){
            for(int i = 0; i < diff; i++){
                pHead2 = pHead2.next;
            }
        }

        //两个链表一起走
        while(pHead1 != null && pHead2 != null){
            if(pHead1.val == pHead2.val)
                return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    //计算链表的长度
    public int count(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}