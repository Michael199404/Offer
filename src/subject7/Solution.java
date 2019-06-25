package subject7;
/*
* 思路：
* 我们先根据前序遍历序列的第一个数字找到根节点，接下来在中序遍历序列中找到
* 根节点的位置，这样就能确定左右子树节点的数量。
* 在前序遍历和中序遍历划分左右子树之后，我们可以递归地调用函数分别去构建它的
* 左右子树
* */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        if(pre.length == 0 || in.length == 0 || pre == null || in == null){
            return null;
        }
        TreeNode root = re(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }

    //重建二叉树
    public TreeNode re(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn){
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        //1.找到根节点
        TreeNode root = new TreeNode(pre[startPre]);
        //2.遍历中序序列，划分左右子树
        for (int i = startIn; i <= endIn; i++) {
            if(in[i] == pre[startPre]){
                root.left = re(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
                root.right = re(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
            }
        }
        return root;
    }
}
