package subject8;
/*
* 面试题八
* 题目描述：
* 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
* 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*
* 思路：
* 1.中序遍历是先左子树后根后右子树
* 2.如果一个节点有右子树，那么中序遍历这个节点的下一个节点是其右子树的最左边的节点
* 3.如果一个节点没有右子树
*   3.1如果这个节点是其父节点的左子节点，那么他的下一个节点就是它的父节点
*   3.2如果这个节点是其父节点的右子节点，我们沿着父节点一直向上，直到找到一个是
*   它父节点左子节点的节点，如果这样的节点存在，那么这个节点的父节点就是我们要找的
*   下一个节点
* */
//定义树的结构
class TreeLinkNode{
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val){
        this.val = val;
    }
}

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode){

        if(pNode == null)
            return null;

        TreeLinkNode pNext = null;

        //如果一个节点有右子树，那么中序遍历这个节点的下一个节点是其右子树的最左边的节点
        if(pNode.right != null){
            TreeLinkNode pRight = pNode.right;
            while(pRight.left != null){
                pRight = pRight.left;
            }
            pNext = pRight;
        }else if(pNode.right == null && pNode.next != null){//如果这个节点右子树为空并且右父节点
            TreeLinkNode cur = pNode;//当前节点
            TreeLinkNode p = pNode.next;//当前节点的父节点
            while(p != null && cur == p.right){
                cur = p;
                p = p.next;
            }
            pNext = p;
        }

        return pNext;
    }
}






















