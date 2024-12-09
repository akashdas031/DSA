package DSA.Recursion;

public class LLMAIN {
    public static void main(String[] args) throws Exception {
        LinkedList list=new LinkedList();
        // list.insertLast(1);
        // list.display();
        // list.deleteLast();
        // list.insertFirst(2);
        // list.insertLast(3);
        // list.display();
        // list.insertLast(0);
        // list.insertLast(-1);
        // list.display();
        // list.deleteLast();
        // System.out.println();
        // list.display();
        // list.insert(1, 1);
        // list.display();
        // list.delete(2);
        // list.display();
        // list.reverse();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        
        list.display();
        list.reversePart(2, 4);
        list.display();

    }
}
