package DoubleLinkedList;

import java.util.Scanner;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> dList = new DoubleLinkedList<Integer>();
        int n;
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        for(int i=0; i<n; i++){
            int value;
            value = reader.nextInt();
            Node<Integer> node = new Node<Integer>(value);
            dList.add(node);
        }
        dList.list();
        System.out.println("-----------------");
        dList.relist();
        System.out.println("-----------------");
        Node<Integer> node2 = new Node<Integer>(3);
        dList.insert(2,node2);
        dList.list();
        System.out.println("-----------------");
        System.out.println(dList.remove(3));
        dList.list();
        System.out.println("-----------------");
        System.out.println(dList.update(3,5));
        dList.list();
    }

}
