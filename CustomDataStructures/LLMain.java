package DSA.CustomDataStructures;

public class LLMain {
  public static void main(String[] args) {
    CustomLinkedList cl=new CustomLinkedList();
    cl.insertLast(2);
    cl.insert(3);
    cl.insert(4);
    cl.insertLast(5);
    cl.insert(6, 3);
    cl.display();
    System.out.println();
    cl.reversePart(2,4);
    cl.display();  
  }
}
