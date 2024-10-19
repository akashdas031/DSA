package DSA.CustomDataStructures;

/**
 * CustomLinkedList
 */
public class CustomLinkedList {

    private class ListNode{
        private ListNode next;
        private int val;
        public ListNode(int val){
            this.val=val;
        }
        public ListNode(ListNode next,int val){
            this.next=next;
            this.val=val;
        }
        public ListNode(){

        }

    }
    private ListNode head;
    private ListNode tail;
    private int size;


   public CustomLinkedList (){
       this.size=0;
    }
    //insert from the first of the linkedlist
    public void insert(int val){
        ListNode node=new ListNode(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size+=1; 
    }
    //delete from the first of the linked list
    public int delete(){
        ListNode temp=new ListNode(0);
        int NodeVal=head.val;
        head=head.next;
        temp.next=head;
        size--;
        return NodeVal;

    }
    //display the linkedlist
    public void display(){
        ListNode temp=head;
        System.out.print("HEAD -> ");
        while(temp !=null){
           System.out.print(temp.val +" -> ");
           temp=temp.next;
        }
        System.out.print(" END ");
    }
    //insert last of the linked list
    public void insertLast(int val){
       if(tail==null){
        insert(val);
        return;
       }
       ListNode node=new ListNode(val);
       tail.next=node;
       tail=node;
       size++;
    }
    //Insert in perticular index
    public void insert(int val,int index){
        if(index==0){
            insert(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        ListNode temp=head;
        while(index>1){
            temp=temp.next;
            index--;
        }
        ListNode node=new ListNode(temp.next, val);
        temp.next=node;
        size++;  
    }
    //delete from the last of the linked list
    public int deleteLast(){
        ListNode temp=head;
        while(temp.next !=tail){
            temp=temp.next;
        }
        int val=tail.val;
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }
    public int size(){
        return this.size;
    }
    //delete perticular node of the list
    public int delete(int index){
        if(index==0){
            return delete();
        }
        if(index==size-1){
           return deleteLast();
        }
        ListNode temp=head;
        while(index>1){
            temp=temp.next;
            index--;
        }
        int val=temp.next.val;
        if(temp.next.next!=null){
           
            temp.next=temp.next.next;
            size--;
        }
        return val;
    }

    // reverse the linked list
    public void reverse() {
        if (size < 2) {
            return;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode after = curr.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = after;
            if (after != null) {
                after = after.next;
            }
        }
        head = prev;
    }
   
    // reverse perticular part of the list
    public void reversePart(int left, int right) {
        if (head == null || left == right) {
            return; // No need to reverse if head is null or left equals right
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move `prev` to the node just before the `left` position
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse the sublist from left to right
        ListNode curr = prev.next; // First node of the sublist
        ListNode after = curr.next; // Node that will be reversed

        for (int i = 0; i < right - left; i++) {
            curr.next = after.next; // Point curr to the next node after `after`
            after.next = prev.next; // Move `after` to the front of the sublist
            prev.next = after; // Reconnect the previous part of the list
            after = curr.next; // Move `after` to the next node to be reversed
        }

        // Update head if the reversed portion includes the first element
        head = dummy.next;
    }
}