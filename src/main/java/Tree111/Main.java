package Tree111;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeNode root = mockTree();
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);


        List<List<Integer>> lists1 = preOrder(root);
        System.out.println(lists1);
    }

    public static TreeNode mockTree(){

        /*
                 1
               2   3
             4 5  6  7
            8 9
         */
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;

        return treeNode1;
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null)
            return new ArrayList<>();



        List res = new ArrayList<>();
        Queue<TreeNode> queue = new  LinkedList<TreeNode>();

        queue.offer(root);

        while (!queue.isEmpty()){
            List tmpList = new ArrayList<Integer>();
            //必须取size while 的话会从头取到尾
            int currentSize = queue.size();
            for (int i=0;i<currentSize;i++){

                TreeNode tmpNode = queue.poll();

                tmpList.add(tmpNode.val);

                if (tmpNode.left!=null)
                    queue.offer(tmpNode.left);

                if (tmpNode.right!=null)
                    queue.offer(tmpNode.right);
            }

            res.add(tmpList);

        }

        return  res;
    }


    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversal(root,res);
        return res;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){

            TreeNode tmpNode = stack.pop();

            if (tmpNode!=null)
                res.add(tmpNode.val);
            else
                continue;

            stack.add(tmpNode.right);
            stack.add(tmpNode.left);

        }
        return res;
    }


    public void preorderTraversal(TreeNode root,List<Integer> list) {
        if (root==null)
            return;

        list.add(root.val);

        preorderTraversal(root.left,list);
        preorderTraversal(root.right,list);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorderTraversal(root,res);
        return res  ;
    }


    //题目连接 226.翻转二叉树
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }


    //236. 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null ;
        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left!=null && right!=null)
            return root;
        else if (left==null && right!=null)
            return right;
        else if (left!=null&& right==null)
            return left;
        else
            return null;
    }

    //101.对称二叉树
    public boolean isSymmetric(TreeNode root) {

        if (root.left==null && root.right==null)
            return true;

        if (root.left!=null && root.right ==null)
            return false;

        if (root.left==null && root.right !=null)
            return false;

        if(root.left.val != root.right.val)
            return false;

        boolean r1 = isSymmetric(root.left);
        boolean r2 = isSymmetric(root.right);

        return r1 && r2;
    }


    public void inorderTraversal(TreeNode root,List<Integer> list) {
        if (root==null)
            return;

        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root; // 游标

        //
        while (cur!=null || !stack.isEmpty()){
            if (cur!=null){
                stack.add(cur);
                cur = cur.left;
            }else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                cur = pop.right;
            }
        }

        return res  ;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorderTraversal(root,res);
        return res  ;
    }


    //中右左 (翻转)---> 左右中
    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> res = new ArrayList<>();


        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){

            TreeNode tmpNode = stack.pop();

            if (tmpNode!=null)
                res.add(tmpNode.val);
            else
                continue;

            stack.add(tmpNode.left);
            stack.add(tmpNode.right);

        }
        Collections.reverse(res);
        return res;
    }


    public void postorderTraversal(TreeNode root,List<Integer> list) {

        if (root==null)
            return;

        postorderTraversal(root.left,list);
        postorderTraversal(root.right,list);
        list.add(root.val);

    }



    public static List<List<Integer>> preOrder(TreeNode root) {

        if(root == null)
            return new ArrayList<>();



        List res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while (!stack.isEmpty()){


            List tmpList = new ArrayList<Integer>();
            //必须取size while 的话会从头取到尾
            int currentSize = stack.size();
            for (int i=0;i<currentSize;i++){

                TreeNode tmpNode = stack.pop();

                tmpList.add(tmpNode.val);

                if (tmpNode.left!=null)
                    stack.add(tmpNode.left);

                if (tmpNode.right!=null)
                    stack.add(tmpNode.right);
            }

            res.add(tmpList);

        }

        return  res;
    }
}
