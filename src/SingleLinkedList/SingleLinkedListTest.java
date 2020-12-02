package SingleLinkedList;

import java.util.Scanner;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        int n;
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList();
        for(int i=0; i<n; i++) {
            int value;
            value = reader.nextInt();
            Node node = new Node(value);
            singleLinkedList.add(node);
        }
       /* SingleLinkedList<Integer> s1 = new SingleLinkedList<Integer>();
        s1.add(new Node(1));
        s1.add(new Node(4));
        s1.add(new Node(7));
        s1.add(new Node(8));
        s1.add(new Node(12));
        SingleLinkedList<Integer> s2 = new SingleLinkedList<Integer>();
        s2.add(new Node(2));
        s2.add(new Node(5));
        s2.add(new Node(7));
        s2.add(new Node(9));
        System.out.println(singleLinkedList.mergeTwoLists(s1,s2));*/
        singleLinkedList.list();
        System.out.println("-----------------");
        Node<Integer> node1 = new Node<Integer>(23);
        singleLinkedList.insert(3,node1);
        singleLinkedList.list();
        System.out.println("-----------------");
        singleLinkedList.remove(3);
        singleLinkedList.list();
        System.out.println("-----------------");
        singleLinkedList.update(2,43);
        singleLinkedList.list();
        System.out.println("-----------------");
        System.out.println(singleLinkedList.countLinkedList());
        System.out.println("-----------------");
        System.out.println(singleLinkedList.findK(3));
        System.out.println("-----------------");
        singleLinkedList.reverse();

    }

}
