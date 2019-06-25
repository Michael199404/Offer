package subject6;

import java.util.*;

/*
* 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
*
* 思路：
* 1.肯定要遍历链表，但是第一个遍历到的节点最后一个输出，这是典型的后进先出
* 2.我们可以利用栈来实现这种顺序
* 3.每经过一个节点，把该节点放入一个栈中
* 4.遍历完成之后，再从栈顶逐个输出节点的值
* */
//定义节点的结构
class ListNode{
    int value;
    ListNode next;
    public ListNode(int value){
        this.value = value;
    }
}

public class PrintListReverse {

    public static void printListReverseByStack(ListNode head){
        if(head == null){//如果为null，直接退出函数
            return;
        }

        //定义一个栈的结构用来实现逆序
        Stack<Integer> stack = new Stack<>();

        //遍历链表
        ListNode p = head;
        while(p != null){
            stack.push(p.value);
            p = p.next;
        }

        //用栈实现逆序打印
        while(!stack.empty()){
            System.out.println(stack.pop() + " ");
        }
    }
}




















