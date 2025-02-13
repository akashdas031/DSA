package DSA.CustomDataStructures;

public class LLMain {
  public static void main(String[] args) {
    CustomLinkedList cl=new CustomLinkedList();
    cl.insertLast(1);
    cl.insertLast(2);
    cl.insertLast(3);
    cl.insertLast(4);
    cl.insertLast(5);
    cl.insertLast(6);
    cl.insertLast(7);
    cl.insertLast(8);
    cl.insertLast(9);
    cl.insertLast(10);
    cl.display();
    System.out.println();
    cl.reverseKgroup(3);
    cl.display(); 

  }
}
