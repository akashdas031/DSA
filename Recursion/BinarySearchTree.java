package DSA.Recursion;

import java.util.Scanner;

public class BinarySearchTree {
    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;
        public TreeNode(){

        }
        public TreeNode(int value){
            this.value=value;
        }
    }
    private TreeNode root;
    public BinarySearchTree(){

    }
    public void insert(int value){
       root=insert(root,value);
    }
    public TreeNode insert(TreeNode node,int value){

        if(node==null){
            node=new TreeNode()
        }
    }

}
