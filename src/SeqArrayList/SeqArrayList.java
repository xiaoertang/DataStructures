package SeqArrayList;

import java.util.Iterator;

/*
  实现功能
  1.初始化数组
  2.在index位置插入元素
  3.删除元素
  4.获得元素
  5.修改元素
  6.判断数组是否为空
  7.清空数组中的元素
  8.输出数组中的元素
  9.重构Iterator迭代器
 */
public class  SeqArrayList <T> {
    private int thesize;     //元素个数
    private final int DEFAULT_MAX = 10;  //数组默认容量
    public T arr[];
    //初始化数组
    public SeqArrayList(){
        doClear();
    }
    //清空数组
    public void clear(){
        doClear();
    }
   //数组初始化
    public void doClear(){
        thesize = 0;
        ensureCapactiy(DEFAULT_MAX);
    }
    //判断数组是否为空
    public boolean isEmply(){
        if(size() == 0){
            return true;
        }else {
            return false;
        }
    }
    //返回地址为idx的值
    public T get(int idx){
        if(idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[idx];
    }
    //修改数组中的元素,并返回被修改的数
    public T Update(int idx, T e){
        if(idx<0 || idx>=size()){
            throw  new ArrayIndexOutOfBoundsException();
        }
        T old = arr[idx];
        arr[idx] = e;
        return old;
    }
    public int size(){
        return thesize;
    }
    //构造数组
    public void ensureCapactiy(int newCapacity){
        if(newCapacity < thesize){
            return ;
        }
        T old[] = arr;
        arr = (T []) new Object[newCapacity];
        //如果原数组容量不够，则扩大数组容量，并将数组中的元素，赋给新的数组
        for(int i=0; i<size(); i++){
            arr[i] = old[i];
        }
    }
    public boolean add(T e) {
        add(size(), e);
        return true;
    }
    public void add(int idx, T e){
        //数组容量已满，数组进行扩大
        if(arr.length == size()){
            ensureCapactiy(size());
        }
        //往后移动一个位置
        for(int i = thesize; i>idx; i--){
            arr[i] = arr[i-1];
        }
        //将 e 插在idx位置上，数组元素个数加一
        arr[idx] = e;
        thesize++;
    }
    //删除下标为idx的元素,并返回该下标的值
    public T remove(int idx){
        if(idx <0 || idx >=size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        T removeitem = arr[idx];
        for(int i=idx; i<size()-1;i++){
            arr[i] = arr[i+1];
        }
        thesize--;//元素个数减一
        return removeitem;

    }
    public java.util.Iterator<T> iterator(){
        return new ArrayListIterator();
    }
    //继承Iterator,并重写hasNext、next和remove
    private class ArrayListIterator implements java.util.Iterator<T>{
        private int current = 0;
        public boolean hasNext(){
            return current < size();
        }
        public T next(){
            if(!hasNext()){
                throw new ArrayIndexOutOfBoundsException();
            }
            return arr[current++];
        }
        public void remove(){
            SeqArrayList.this.remove(--current);
        }
    }
}
