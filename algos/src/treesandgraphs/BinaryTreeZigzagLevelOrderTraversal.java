package treesandgraphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean rightSide = true;
        while(!q.isEmpty()) {
            int n = q.size();
            LinkedList<Integer> subList = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                TreeNode currentNode = q.poll();
                if(currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    q.add(currentNode.right);
                }
                if(rightSide) {
                    subList.add(currentNode.val);
                } else {
                    subList.addFirst(currentNode.val);
                }
            }
            rightSide = !rightSide;
            list.add(subList);
        }
        return list;
    }


}
