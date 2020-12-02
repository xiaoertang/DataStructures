package ArrayStack;

public class ArrayStack<T> {
    public T [] arr = null;
    public int top;
    public int maxsize;
    public ArrayStack(int maxSize){
        this.maxsize = maxSize;
        arr = (T[]) new Object[maxSize];
        this.top = -1;
    }
    public boolean isFull(){
        return top==maxsize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public int size(){
        return top+1;
    }
    public void push(T e){
        if(isFull()){
            throw new RuntimeException();
        }
        top++;
        arr[top] = e;
    }
    public void pop(){
        if(isEmpty()){
            throw new RuntimeException();
        }
        T value = arr[top];
        arr[top] = null;
        top--;
    }
    public T getTop(){
        if(isEmpty()){
            throw new RuntimeException();
        }
        return arr[top];
    }
    public void print(){
        if(isEmpty()){
            throw new RuntimeException();
        }
        for(int i=top; i>=0; i--){
            System.out.println(arr[i]);
        }
    }
}
