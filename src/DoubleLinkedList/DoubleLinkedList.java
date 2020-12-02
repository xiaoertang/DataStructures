package DoubleLinkedList;

class Node<T> {
    public T e;
    public Node<T> next;
    public Node<T> pre;

    public Node(Object obj) {
        this.e = (T) obj;
        this.next = null;
        this.pre = null;
    }

    @Override
    public String toString() {
        return "Node{" + "e=" + e + "}";
    }
}

/*
双向链表的实现功能：遍历，添加，修改，删除
1.遍历和单链表一样，只是可以向前，也可向后查找
2.添加(默认添加到双链表的最后一个结点)
  1)先找到双向链表的最后一个结点
  2)p.next = newNode;
  3)newNode.pre = p;
3.修改和单链表一样
4.删除结点
  1)因为是双向链表，因此，我们可实现自我删除某个结点
  2)直接找到要删除的结点，例如结点p
  3)p.per.next = p.next
  4)p.next.pre = p.per
5.插入结点
  1)链表不为空
  2)idx大于0小于链表长度
 */
public class DoubleLinkedList<T> {
    //先初始化一个头结点，头结点不要动
    private Node head = new Node(null);

    public int length() {
        Node<T> p = head;
        int count = 0;
        while (p.next != null) {
            p = p.next;
            count++;
        }
        return count;
    }
    //到着输出
    public void relist(){
        Node<T> p = head;
        //先循环到链尾
        while(p.next!=null){
            p = p.next;
        }
        //然后再循环输出
        while(p.pre!=null){
            System.out.println(p);
            p = p.pre;
        }
    }
    //遍历双向链表
    public void list() {
        Node<T> p = head.next;
        while (true) {
            if (p == null) {
                break;
            }
            System.out.println(p);
            p = p.next;
        }
    }

    //在链表尾部添加结点
    public void add(Node<T> e) {
        Node<T> p = head;
        while (true) {
            if (p.next == null) {
                break;
            }
            p = p.next;
        }
        p.next = e;
        e.pre = p;
    }

    //向双向链表添加下标为idx值为e的值
    public void insert(int idx, Node<T> e) {
        Node<T> p = head;
        boolean flag = false;
        int j = 0;
        while (idx >= 0 && idx < length() || p.next != null) {
            if (j == idx - 1) {
                flag = true;
                break;
            }
            j++;
            p = p.next;
        }
        if (flag) {
            p.next.pre = e;
            e.next = p.next;
            p.next = e;
            e.pre = p;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    //修改下标为idx的结点的值
    public T update(int idx, T value) {
        Node<T> p = head;
        int j = 0;
        boolean flag = false;
        while (p.next != null || idx >= 0 && idx < length()) {
            if (j == idx) {
                flag = true;
                break;
            }
            j++;
            p = p.next;
        }
        if (flag) {
            T updataValue = p.e;
            p.e = (T) value;
            return updataValue;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    public T remove(int idx) {
        Node<T> p = head;
        boolean flag = false;
        int j = 0;
        while (p.next != null || (idx >= 0 && idx < length())) {
            if (j == idx) {
                flag = true;
                break;
            }
            j++;
            p = p.next;
        }
        T removeData = (T) p.e;
        if (flag) {
            p.pre.next = p.next;
            //当删除的结点不是最后一个结点，执行该语句
            if (p.next != null) {
                p.next.pre = p.pre;
            }
            return removeData;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
