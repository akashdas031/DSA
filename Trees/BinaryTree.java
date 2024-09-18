package DSA.Trees;

import java.util.Scanner; 

public class BinaryTree { // Public class declaration for BinaryTree
    private class TreeNode{ // Private inner class declaration for TreeNode
        private TreeNode left; // Left child node
        private TreeNode right; // Right child node
        private int value; // Value of the current node
        public TreeNode(){ // No-argument constructor for TreeNode
        }
        public TreeNode(int value){ // Parameterized constructor for TreeNode
            this.value=value; // Initializing the value of the node
        }
    }
    private TreeNode root; // Root node of the binary tree
    public BinaryTree(){ // No-argument constructor for BinaryTree
    }

    public void insert(Scanner sc){ // Method to insert nodes into the binary tree
        sc=new Scanner(System.in); // Creating a new Scanner object for user input
        System.out.println("Enter the Value of the Root Node..."); // Prompt for root node value
        int value=sc.nextInt(); // Reading the root node value
        root=new TreeNode(value); // Creating the root node
        helper(root,sc); // Calling the helper method to insert nodes recursively
    }
    private void helper(TreeNode root,Scanner sc){ // Recursive helper method for inserting nodes
      System.out.println("Do you want to insert in left side of :"+root.value); // Prompt for left child node
      boolean side=sc.nextBoolean(); // Reading the user's choice for left child node
      if(side){ 
        System.out.println("Enter the value for left node"+root.value); 
        int val=sc.nextInt(); 
        root.left=new TreeNode(val); 
        helper(root.left,sc); // Recursively calling the helper method for the left child node
      }
      System.out.println("Do you want to insert in the right side of the root :"+root.value); 
      boolean isRight=sc.nextBoolean(); 
      if(isRight){ 
        System.out.println("Enter the value for the right node :"+root.value); 
        int val=sc.nextInt(); 
        root.right=new TreeNode(val); 
        helper(root.right,sc); // Recursively calling the helper method for the right child node
      }
    }
    public void display() { // Method to display the binary tree
        display(this.root, ""); // Calling the private display method with the root node and an empty indent
      }
    private void display(TreeNode node, String indent) { // Private method to display the binary tree recursively
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