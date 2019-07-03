package subject18;

import java.util.Scanner;

/*
* 在O(1)时间内删除链表的结点
*
* 思路：
* 1.一般的思路是我们从头结点开始找到要删除结点的前一个结点，
* 使这个结点直接连接到要删除结点的下一个结点，这样就删除了
* 这个结点。但是这样做，时间复杂度为O(n)。
* 2.如果我们不找要删除结点的前一个结点行不行呢？
* 3.我们找到要删除结点的下一个结点，这么做的时间复杂度为O(1),用
* 这个结点将要删除的结点覆盖，然后在删除要删除结点的下一个结点
* 4.这里要考虑到一些特殊的情况，比如边界值等等
*   4.1如果要删除的结点不是尾结点，那么可以直接将下一个节点的值赋给该节点，然后令该节点指向下下个节点
*   4.2如果要删除的结点位于链表的尾部，我们就需要遍历得到该节点的前一个结点，然后删除该结点
* */
class ListNode{
    ListNode next;
    int val;
    public ListNode(int val){
        this.val = val;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();//输入结点的个数
            for (int i = 0; i < n; i++) {

            }
        }
    }

    public ListNode deleteNode(ListNode head, ListNode tobeDelete){
        if(head == null || tobeDelete == null)
            return null;

        //要删除的结点不是尾结点
        if(tobeDelete.next != null){
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        }else{//如果要删除的结点使尾结点
            if(head == tobeDelete){//如果只有一个结点
                head = null;
            }else{//不止有一个结点
                ListNode cur = head;
                while(cur.next != tobeDelete){
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        return head;
    }
}
