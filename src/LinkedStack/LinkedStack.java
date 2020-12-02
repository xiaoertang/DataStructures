package LinkedStack;
class Node<AnyType>{
    AnyType data;
    Node<AnyType> next;
    //构造器
    public Node(Object obj){
        this.data = (AnyType) obj;
    }
    @Override
    //重写toString
    public String toString(){
        return "Node[" + "data=" + data + "]";
    }
}
public class LinkedStack<AnyType> {
    private Node head = new Node(null);
    //public Node top = head;
    public void push(Node node){//在尾部添加元素
        Node p = head;
        while(p.next!=null){
            p = p.next;
        }
        p.next = node;
    }
    public void pop(){
        Node p = head;
        if(p.next==null){//栈为空，出栈失败
            throw new RuntimeException();
        }
        while(p.next.next!=null){
            p = p.next;
        }
        p.next = null;
    }
    public AnyType top(){
        Node p = head;
        if(p.next==null){//栈为空，获取栈顶失败
            throw new RuntimeException();
        }
        while(p.next != null){
            p = p.next;
        }
        return (AnyType) p.data;
    }
    public int size(){
        int count = 0;
        Node p = head;
        while(p.next!=null){
            p = p.next;
            count++;
        }
        return count;
    }
    public void print(){
        Node p = head;
        while(p.next!=null){
            p = p.next;
            System.out.println(p);
        }
    }
}
