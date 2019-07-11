package subject26;
/*
* 树的子结构
*
* 思路：
* 1.在树A中找到和树B的根结点的值一样的结点R
* 2.判断树A中以R为根节点的子树是不是包含和树B一样的结构
* */

import javax.swing.tree.TreeNode;

class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;

    }

 }
public class Solution {
    public boolean HasSubtree(TreeNode1 root1,TreeNode1 root2) {
        //我们约定空树不是任意一棵树的子结构
        if(root2 == null){
            return false;
        }

        if(root1 == null && root2 != null)
            return false;

        boolean result = false;

        //如果根节点相同，就判断B是不是A的子结构
        if(root1.val == root2.val)
            result = DoesTree1HaveTree2(root1, root2);

        //flag==false说明没有找到子结构，这是到root1的左子树去找
        if(result == false)
            result = HasSubtree(root1.left,root2);
        if(result == false)
            result = HasSubtree(root1.right,root2);
        return result;
    }

    public boolean DoesTree1HaveTree2(TreeNode1 root1, TreeNode1 root2){
        if(root2 == null)
            return true;

        if(root1 == null)
            return false;

        if(root1.val == root2.val)
            return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
        else
            return false;
    }
}
