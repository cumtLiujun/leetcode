import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class levelOrde_32 {
    /**
     *
     * 层序遍历 BFS 一般利用队列的特性进行 遍历；
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            ans.add(temp.val);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }

        int[] res = new int[ans.size()];
        for (int i = 0 ;i < ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    /**
     * 根据树的层次进行数据输出，使用List<list>存储返回
     *
     *
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0;i--) { //i = queue.size(),记录最初始的大小，避免后续add结果有影响
                TreeNode treeNode = queue.poll();
                tmp.add(treeNode.val);
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            res.add(tmp);
        }
        return res;
    }


    /**
     * LinkedList 具有队列的全部属性，包括双端队列，支持队列，克隆和序列化操作
     * 使用双端队列数据结构，控制不同层数数据队列头或者队尾进入
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size();i>0; i--) {
                TreeNode tree = queue.poll();
                if (res.size() % 2 == 0) tmp.addLast(tree.val);
                else tmp.addFirst(tree.val);
                if (tree.left != null) queue.add(tree.left);
                if (tree.right != null) queue.add(tree.right);
            }
            res.add(tmp);
        }
        return res;
    }

}


class SubStructure_26 {
//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        return (A != null && B !=null) && (recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right, B));
//
//    }

    Boolean recur(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;
        return recur(a.left, b.left) && recur(a.right,b.right);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B){
        if (A == null || B == null){
            return false;
        }
        if (A.val == B.val && recur(A.left, B.left) && recur(A.right,B.right)) {
            return true;
        }
        return isSubStructure(A.right,B) || isSubStructure(A.left,B);
    }

//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        if (A == null || B == null) {
//            return false;
//        }
//
//        if (A.val == B.val && recur(A.right,B.right) && recur(A.right,B.right)){
//            return true;
//        }
//        return isSubStructure(A.right, B) || isSubStructure(A.left, B);
//    }
}

class mirrorTree_27 {
//    递归，终止条件为，越过叶节点，即treeNode == null
//    逆推，使用leftNode作为root的左子节点，保存root.right的递归，反之亦相同；
//
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode leftNode = mirrorTree(root.right);
        TreeNode rightNode = mirrorTree(root.left);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null){
            return null;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode tmp = linkedList.poll();
            if (tmp.right != null) linkedList.add(tmp.right);
            if (tmp.left != null) linkedList.add(tmp.left);
            TreeNode node = tmp.left;
            tmp.left = tmp.right;
            tmp.right = node;
        }
        return root;
    }
}