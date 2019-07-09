package subject25;

/*
题目：
合并两个排序链表

思路：
1.定义两个指针p1和p2，p1遍历第一个排序链表，p2遍历第二个排序链表
2.每次比较p1和p2指向的结点的大小，将小的那个插入新链表中
3.如果某一个链表已经遍历结束，就将第二个链表中剩下的结点依次插入到新链表当中

*/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        //定义两个指针
        ListNode p1 = list1;
        ListNode p2 = list2;

        //定义一个新的链表
        ListNode list3 = new ListNode(0);
        ListNode p3 = list3;

        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                p3.next = p1;
                p1 = p1.next;
                p3 = p3.next;
            }else{
                p3.next = p2;
                p2 = p2.next;
                p3 = p3.next;
            }
        }

        //如果list1还没有遍历完
        while(p1 != null){
            p3.next = p1;
            p1 = p1.next;
            p3 = p3.next;
        }

        //如果list1还没有遍历完
        while(p2 != null){
            p3.next = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        return list3.next;
    }
}

