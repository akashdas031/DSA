package DSA.Trees;

import java.util.Scanner;

import org.w3c.dom.Node;

public class BinaryTree {
    private class TreeNode{
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
    public BinaryTree(){
        
    }

    public void insert(Scanner sc){
         sc=new Scanner(System.in);
        System.out.println("Enter the Value of the Root Node...");
        int value=sc.nextInt();
        root=new TreeNode(value);
        helper(root,sc);
    }
    private void helper(TreeNode root,Scanner sc){
      sc=new Scanner(System.in);
      System.out.println("Do you want to insert in left side of :"+root.value);
      boolean side=sc.nextBoolean();
      if(side){
        System.out.println("Enter the value for left node"+root.value);
        int val=sc.nextInt();
        root.left=new TreeNode(val);
        helper(root.left,sc);
      }
      System.out.println("Do you want to insert in the right side of the root :"+root.value);
      boolean isRight=sc.nextBoolean();
      if(isRight){
        System.out.println("Enter the value for the right node :"+root.value);
        int val=sc.nextInt();
        root.right=new TreeNode(val);
        helper(root.right,sc);
      }
    }
    public void display() {
        display(this.root, "");
      }
    private void display(TreeNode node, String indent) {
    if (node == null) {
      return;
    }
    System.out.println(indent + node.value);
        if (node.left != null && node.right != null) {
            display(node.left, indent + "├── LEFT Node : ");
            display(node.right, indent + "└── RIGHT Node : ");
        } else if (node.left != null) {
            display(node.left, indent + "└── LEFT Node : ");
        } else if (node.right != null) {
            display(node.right, indent + "└── RIGHT Node : ");
        }
  }


}
