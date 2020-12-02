package ArrayStack;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        stack.push(2);
        stack.push(4);
        stack.push(23);
        stack.push(7);
        stack.push(2);
        stack.print();
        System.out.println("---------");
        stack.pop();
        System.out.println("---------");
        stack.print();
        System.out.println("---------");
        System.out.println(stack.getTop());
        System.out.println("---------");
        System.out.println(stack.size());
    }
}
