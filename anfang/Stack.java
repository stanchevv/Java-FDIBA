package anfang;

public class Stack {
    protected Node head;

    public Stack(){
        Node head = new Node();
    }

    public void push(Object obj){
        this.head = new Node(obj,this.head);
    }

    public Object pop(){
        Object result = new Object();
        result = this.head.getObj();
        this.head = this.head.getPrevious();
        return result;
    }

    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }
}
