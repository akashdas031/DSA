package DSA.Recursion;

import java.util.Scanner;

public class BinaryTree {
    private class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(){

        }
        public TreeNode(int value){
            this.value=value;
        }
    }
    private TreeNode root;
    public BinaryTree(){

    }
    public void insert(Scanner sc){
        sc=new Scanner(System.in);
        System.out.println("Enter the value of the Root Node");
        int rVal=sc.nextInt();
        root=new TreeNode(rVal);
        helper(root,sc);
    }
    public void helper(TreeNode node,Scanner sc){
        System.out.println("Do you want to insert to the left Side ??? Enter True or False...");
        boolean side=sc.nextBoolean();
        if(side){
           System.out.println("Enter the value for left of the Node :"+node.value);
           int nodeVal=sc.nextInt();
           node.left=new TreeNode(nodeVal);
           helper(node.left, sc);
        }
        System.out.println("Do you want to insert int the right side of the Node :"+node.value);
        boolean isRight=sc.nextBoolean();
        if(isRight){
            System.out.println("Enter the value for Right of the Node :"+node.value);
            int nodeVal=sc.nextInt();
            node.right=new TreeNode(nodeVal);
            helper(node.right,sc);
        }
    }
    public void display(){
        display(this.root,"");
    }
    public void display(TreeNode node,String indent){
        if(node==null){
            return;
        }
        System.out.println(indent+node.value);
        if(node.left !=null && node.right != null){
            display(node.left, indent+"├── LEFT Node : ");
            display(node.right,indent+"└── RIGHT Node: ");
        }else if(node.left==null){
            display(node.right,indent+"├── LEFT Node : ");
        }else{
            display(node.right,indent+"└── RIGHT Node: ");
        }
    }
}
