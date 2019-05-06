package anfang;

public class Node {
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public Node getPrevious() {
        return previous;
    }

    private Node previous;

    public Node(){
        this.obj = null;
        this.previous = null;
    }

    public Node(Object obj, Node previous){
        this.obj = obj;
        this.previous = previous;
    }

    char bukva = 'a';
}




