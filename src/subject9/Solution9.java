package subject9;

import java.util.Stack;

/*
* 面试题九：用两个栈实现队列
*
* 题目描述：
* 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
*
* 思路：
* 1.当stack2不为空时，在stack2栈顶的元素就是最先入队的元素
* 2.如果stack1要往stack2中插入新的元素，必须保证stack2中为空
* */
public class Solution9 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //入队操作
    public void push(int node){
        stack1.push(node);
    }

    //出队操作
    public int pop(){
        //如果stack2为空，就将stack1中的元素全部插入到stack2中
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        //如果stack2不为空，直接将栈顶的元素出栈
        return stack2.pop();
    }
}
