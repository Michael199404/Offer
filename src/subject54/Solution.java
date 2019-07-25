package subject54;

import java.util.*;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/*
思路：
设置一个全局变量，对二叉搜索树进行中序遍历的过程中，每遍历到一个
节点，变量的值加一
*/

public class Solution {

    int count = 0;
    TreeNode node = null;

    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null){
            return null;
        }
        inOrder(pRoot, k);
        return node;
    }

    //中序遍历二叉树，将节点存储在一个集合当中
    public void inOrder(TreeNode root, int k){
        if(root != null){
            inOrder(root.left, k);
            count++;
            if(count == k){
                node = root;
            }
            inOrder(root.right, k);
        }
    }
}
