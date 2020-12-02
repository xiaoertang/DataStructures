package SingleLinkedList;

import java.util.Stack;

//结点
class Node<T> {
    public T e;
    public Node<T> next;

    //构造器
    public Node(T obj) {
        this.e = obj;
    }

    //重写toString
    @Override
    public String toString() {

        return "Node{" + "e=" + e + "}";
    }
}

public class SingleLinkedList<T> {
    //先初始化一个头结点，头结点不要动
    private final Node<T> head = new Node(null);

    //向单链表添加数据
    //思路： 1.找到单链表的最后一个结点
    //      2.将最后这个结点next指向新的结点
    public void add(Node L) {
        Node<T> p = head;  // 头结点
        while (true) {
            //遍历单链表，找到最后
            if (p.next == null) {  //p.next指向第一个结点
                break;
            }
            //如果找不到最后，将p后移
            p = p.next;
        }
        //当退出循环，将要加的结点赋给单链表的最后
        p.next = L;
    }

    //显示单链表的内容
    public void list() {
        Node<T> p = head.next;//p指向第一个结点
        while (true) {
            if (p == null) { // 所以p是第一个结点
                break;
            }
            //输出单链表的内容
            System.out.println(p);
            p = p.next;
        }
    }

    //在index的位置插入一个值
    /*
    1.找到与index相同的下标
     */
    public void insert(int idx, Node<T> e) {
        Node<T> p = head;
        int j = 0;
        boolean flag = false; //标记
        while ((j >= 0 && j < countLinkedList() - 1) || p.next != null) {
            if (j == idx-1) {
                flag = true;
                break;
            }
            j++;
            p = p.next;
        }
        if (flag) {
            e.next = p.next;
            p.next = e;

        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    //删除结点操作
    /*
      思路：
          1.如果没找到该数,不能进行删除操着
          2.找到该数，将该结点删除：p.next = p.next.next;
    删除第一个元素，下标从0开始
     */
    public T remove(int idx) {
        Node p = head;
        boolean flag = false;  //标记是否找到该结点
        int j = 0;
        while (j >= 0 && j < countLinkedList() || p.next != null) {
            if (j == idx) { //循环到链尾
                flag = true;
                break;
            }
            j++;
            p = p.next;
        }
        T removeData = (T) p.e;
        if (flag) {

            p.next = p.next.next;
        } else {
            throw new ArrayIndexOutOfBoundsException();
            //保存要删除的元素
        }
        return removeData;
    }

    /*
    更新下表为idx的元素
     */
    public T update(int idx, T e) {
        Node<T> p = head;
        int j = 0;
        boolean flag = false;
        while ((idx >= 0 && idx < countLinkedList() )|| p.next != null) {
            if (j == idx) {
                flag = true;
                break;
            }
            j++;
            p = p.next;
        }
        if (flag) {
            T updataValue = p.e;
            p.e = (T) e;
            return updataValue;

        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    //查看链表中有效元素个数,返回个数
    public int countLinkedList() {
        Node<T> p = head;
        int count = 0;
        if (p.next == null) {
            return 0;
        }
        while (true) {
            if (p.next == null) {
                break;
            }
            count++;
            p = p.next;
        }
        return count;
    }

    //查找单链表中倒是第k个结点【新浪面试题】
    /*
    思路：
    1.统计链表中有效元素的个数
    2.查找倒数第k个元素,即count-k
     */
    public Node<T> findK(int k) {
        Node<T> p = head;
        if (countLinkedList() == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int curr = 0;
        while (curr < countLinkedList() - k + 1) {
            p = p.next;
            curr++;
        }
       // Math.max(1,2);
        return p;
    }
    /*
    单链表反转
     借助栈进行反转
     */
    public void reverse() {
        Node<T> p = head.next;
        if (p.next == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Stack<Node> s = new Stack<Node>();
        while (p != null) {
            s.add(p);
            p = p.next;
        }
        while (s.size() > 0) {
            System.out.println(s.pop());
        }

    }
    /*public Node<Integer> mergeTwoLists(Node<Integer> l1, Node<Integer> l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        Node<Integer> p = new Node<Integer>(null);
        Node<Integer> cur = p;
        int flag = 0;
        while(true){
            if(l1.e <= l2.e){
                if(l1==null){
                    flag = 1;
                    break;
                }
                cur.next = l1;
                l1 = l1.next;
            }else{
                if(l2==null){
                    flag = 2;
                    break;
                }
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(flag==1){
            cur.next = l2;
        }
        if(flag==2){
            cur.next = l1;
        }
        return p.next;
    }*/
}
