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
    public ListNode oddEvenList(){
        return oddEvenList(head);
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode odd=head;
        ListNode even=head.next;
        ListNode newHead=even;

        while(even !=null && even.next != null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=newHead;
        return head;
    }
    //reverse k alternative groups in a linked list
    public ListNode reverseKgroup(int k){
        return reverseKgroup(head,k);
    }
    public ListNode reverseKgroup(ListNode head,int k){
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = dummy.next;
        boolean shouldReverse = true;

        while (curr != null) {
            ListNode start = prev.next;
            ListNode end = curr;
            int count = 0;

            // Move end pointer k steps ahead if possible
            while (count < k && end != null) {
                end = end.next;
                count++;
            }

            if (count == k) {
                if (shouldReverse) {
                    prev.next = reverseKelement(start, k);
                    start.next = end; // Connect the reversed part with the remaining list
                    prev = start;
                } else {
                    prev = start; // Move prev pointer without reversing
                }
                shouldReverse = !shouldReverse; // Toggle reversal for alternate groups
            }
            curr = end;
        }
        return dummy.next;
    }

    // Function to reverse k nodes in a linked list
    private static ListNode reverseKelement(ListNode head, int k) {
        ListNode prev = null, curr = head;
        while (k-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}