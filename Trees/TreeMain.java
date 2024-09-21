package DSA.Trees;

import java.util.Scanner;

public class TreeMain {
   public static void main(String[] args) {
   //  BinaryTree bt=new BinaryTree();
   //  Scanner sc=new Scanner(System.in);
   //  bt.insert(sc);
   //  bt.display();
   BinarySearchTree bst=new BinarySearchTree();
   bst.insert(3);
   bst.insert(2);
   bst.insert(5);
   bst.insert(4);
   bst.insert(1);
   bst.insert(6);
   bst.insert(7);
   bst.display();
   System.out.println(bst.isBalanced());
   System.out.println(bst.isEmpty());
   
   }
}
