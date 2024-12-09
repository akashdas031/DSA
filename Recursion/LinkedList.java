package DSA.Recursion;

public class LinkedList {
    private class ListNode{
        ListNode next;
        int data;
        public ListNode(){

        }
        public ListNode(int data){
            this.data=data;
        }
        public ListNode(int data,ListNode next){

            this.data=data;
            this.next=next;
        }
    }
    private ListNode head;
    private ListNode tail;
    private int size;
    public LinkedList(){
        this.size=0;
    }
    //insert at the first of the linked list
    public void insertFirst(int value){
       
        ListNode node=new ListNode(value);
        node.next=head;
        head=node;

        if(tail==null){
            tail=head;
        }
        size+=1;
    }
    //display the linked list
    public void display(){
        ListNode temp=head;
        System.out.print("HEAD->");
        while(temp!=null){
            
            System.out.print(temp.data+"-> ");
            temp=temp.next;
        }
        System.out.print("TAIL");
    }
    //delete from the first of the linked list
    public int deleteFirst() throws Exception{
        
        ListNode node=new ListNode(0);
        int val=head.data;
        head=head.next;
        node.next=head;
        size-=1;
        return val;
        
    }
    //insert at the end of the linked list
    public void insertLast(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
       
        ListNode newNode=new ListNode(value);
        tail.next=newNode;
        tail=newNode;
        size+=1;
    }
    //delete from the end of the linked list
    public int deleteLast(){
       //if only one element present in the list
        if(head.next==null){
            int val=head.data;
            head=null;
            tail=head;
            size-=1;
            return val;
        }
        ListNode node=head;
        while(node.next!=tail){
            node=node.next;
        }
        int val=tail.data;
        node.next=null;
        node=tail;
        size-=1;
        return val;
    }
    //insert in any perticular index of the linked list
    public void insert(int index,int val){
        if(index==0){
            insertFirst(val);
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
        ListNode node=new ListNode(val,temp.next);
        temp.next=node;
        size+=1;
    }
    //delete from any perticular index
    public int delete(int index) throws Exception{
        if(index==0){
            deleteFirst();
        }
        if(index==size){
            deleteLast();
        }
        ListNode node=head;
        while(index>1){
            node=node.next;
            index--;
        }
        int val=node.data;
        node.next=node.next.next;
        size-=1;
        return val;
    }
    //Reverse the list
    public void reverse(){
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
    public void reverseAlternativePart(int k){
       if(k>size){
        return;
       } 
       
    }


}
