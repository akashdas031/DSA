package DSA.Trees;

public class BinarySearchTree {
    private class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
        private int height;
        public TreeNode(int value){
            this.value=value;
        }
    }
    //root node created
    private TreeNode root;
    public BinarySearchTree(){

    }
    //height of the BST
    public int getHeight(TreeNode node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    //check the tree is empty or not
    public boolean isEmpty(){
        return root==null;
    }
    //insert into the binary search tree
    public void insert(int value){
       root= insert(root,value);
    }
    
    private TreeNode insert(TreeNode node,int value){
        if(node==null){
          node=new TreeNode(value);
          return node;
        }
        //check if the value if less than the current node and if so then recursively go the left most node untill 
        //getting null as node value
        if(value<node.value){
           node.left=insert(node.left,value);
        }
        //check if the value if less than the current node and if so then recursively go the left most node untill 
        //getting null as node value
        if(value>node.value){
            node.right=insert(node.right,value);
        }
        //after each insertion update height of the tree
        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
        return node;

    }
    //Display the tree 
    public void display(){
        display(root,"Root Node :");
    }
    private void display(TreeNode node,String property){
        //if the value of the node is null then just return
        if(node==null){
            return;
        }
        System.out.println(property+node.value);
        display(node.left,"Left Child of :"+node.value+": ");
        display(node.right,"Right Child of :"+node.value+": ");
        

    }
    //check the tree is balanced or not
    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(TreeNode node){
        if(node==null){
            return true;
        }
        return Math.abs(getHeight(node.left)-getHeight(node.right))<=1 && isBalanced(node.left) && isBalanced(node.right);
    }

}
