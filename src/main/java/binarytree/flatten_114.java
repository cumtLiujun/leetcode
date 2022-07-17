package binarytree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class flatten_114 {
    /*
    二叉树展开为链表：
    1、有图可得展开顺序为root->left->root符合
    2、保存node进行重建
     */
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> res =new ArrayList<>();
        TreeNode node = root;
        inorder(node, res);
        for (int i = 1; i < res.size(); i++){
            root.left = null;
            root.right = res.get(i);
            root = root.right;
        }
    }

    public void inorder(TreeNode node, ArrayList<TreeNode> res) {
        if (node == null) return;
        res.add(node);
        if (node.left != null) inorder(node.left, res);
        if (node.right != null) inorder(node.right, res);
    }
}
