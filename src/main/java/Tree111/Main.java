package Tree111;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        TreeNode root = mockTree();
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
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


}
