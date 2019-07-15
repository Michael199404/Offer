package subject30;

import java.util.Stack;

/*
* 包含min函数的栈
*
* 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
*
* 思路：
* 1.使用一个辅助栈
* 2.辅助栈用来实现min函数的功能
* 3.每次将一个数压入主栈的时候，判断这个数是不是最小值，如果是，就
* 将这个数同时压入辅助栈中，所以在辅助栈的栈顶中，一直保存的是最小值
* 4.如果压入的这个数字比最小值要大，则在辅助栈中压入辅助栈的栈顶元素
* 5.在出栈的时候，如果出栈的数字和辅助栈栈顶的元素相同，则辅助栈和主栈
* 同时出栈
* */
public class Solution {

    Stack<Integer> stack1 = new Stack<>();//主栈
    Stack<Integer> stack2 = new Stack<>();//辅助栈

    //入栈
    public void push(int node) {
        stack1.push(node);
        if(stack2.size() == 0 || node < stack2.peek()){
            stack2.push(node);
        }else{
            stack2.push(stack2.peek());
        }
    }

    //出栈
    public void pop() {
        if(stack1.size() > 0 && stack2.size() > 0){
            stack1.pop();
            stack2.pop();
        }
    }

    public int top() {
        if(stack1.size() > 0)
            return stack1.peek();
        return 0;
    }

    //获得栈的最小值
    public int min() {
        if(stack1.size() > 0 && stack2.size() > 0)
            return stack2.peek();
        return 0;
    }
}
