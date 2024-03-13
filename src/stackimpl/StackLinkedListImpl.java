package stackimpl;

public class StackLinkedListImpl {

    int size;
    Node head;
    public void push(int data){
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }

    public int pull(){
        if(head==null) throw new IllegalStateException("NO item available");
        Node temp = head;
        int res = temp.data;
        head = temp.next;
        size--;
        return res;
    }

    public int peek(){
        if(head==null) throw new IllegalStateException("NO item available");
        return head.data;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }


    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
