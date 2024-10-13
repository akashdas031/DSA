package DSA.Trees;

import java.util.Arrays;

public class ConstructTreeFromPreOrderAndInOrder {
    private static  class TreeNode{ // Private inner class declaration for TreeNode
        private TreeNode left; // Left child node
        private TreeNode right; // Right child node
        private int value; // Value of the current node
        public TreeNode(int value){ // Parameterized constructor for TreeNode
            this.value=value; // Initializing the value of the node
        }
    }
    //without hashmap
    public static TreeNode constructTree(int[] preorder,int[] inorder){
        //return if one of the array is empty
        if(preorder.length==0 || inorder.length==0){
            return null;
        }
        //as preorder follows Root->left->Right sequence the first element of the preorder array is the root node
        int rootVal=preorder[0];
        //create a node with that value
        TreeNode root=new TreeNode(rootVal);
        //find the element in the inorder array like inorder follows Left->Root->Right 
        //till the index from the left side the elements are the part of the left tree and from the element to the 
        //end of the inorder array is the right part of the tree
        int index=-1;
        for(int i=0;i<inorder.length;i++){
          if(rootVal==inorder[i]){
            index=i;
          }
        }
        //find recursively and divide the array using arrays.copyofange which meand it create a copy of the array within the range
        root.left=constructTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder,0,index));
        root.right=constructTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder,index+1,inorder.length));
        printTree(root, "Root");
        return root;
    }
    //using hashmap to be implement here

    /*
     * 
     */
    //print the tree with in-order traversal
    public static void printTree(TreeNode root,String s){
        if(root==null){
            return;
        }
        System.out.println(root.value+s);
        printTree(root.left ,"Left Of "+root.value);
       
        printTree(root.right, "Right of "+root.value);
    }
    //main
    public static void main(String[] args) {
        int[] preorder={1,2,4,8,9,5,3,6,7};
        int[] inorder={8,4,9,2,5,1,6,3,7};
         constructTree(preorder, inorder);

    }

}
