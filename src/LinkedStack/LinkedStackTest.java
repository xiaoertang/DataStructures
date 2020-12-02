package LinkedStack;

public class LinkedStackTest {
    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();
        for(char i='a'; i<='z'; i++){
            Node node = new Node(i);
            stack.push(node);
        }
        stack.print();
        System.out.println("------");
        stack.pop();
        stack.print();
        System.out.println("------");
        System.out.println(stack.top());
        System.out.println("------");
        System.out.println(stack.size());
    }
}
