package database;

public class BSTree<T extends Comparable<T>>{

    public class BSTNode<T extends Comparable<T>> {
        T key;
        BSTNode<T> left;
        BSTNode<T> right;
        BSTNode<T> parent;

        public BSTNode(T key, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
            this.key = key;
            this.left= left;
            this.right = right;
            this.parent = parent;
        }
    }

    private BSTNode<T> mRoot;


//    前序遍历
    private void preOrder(BSTNode<T> root) {
        if (root != null) {
            System.out.println(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

//    中序遍历
    private void inOrder(BSTNode<T> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }

//    后序遍历
    private void postOrder(BSTNode<T> root) {
        if (root != null) {
           postOrder(root.left);
           postOrder(root.right);
           System.out.println(root.key);
        }
    }

//    查找节点

    private BSTNode<T> search(BSTNode<T> root, T key) {
        if (root == null) {
            return null;
        }

        int cmp = key.compareTo(root.key);

        if (cmp < 0) {
            return search(root.left, key);
        } else if (cmp > 0) {
            return search(root.right, key);
        } else {
            return root;
        }
    }


}
