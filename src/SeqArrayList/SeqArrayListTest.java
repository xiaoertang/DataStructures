package SeqArrayList;

import java.util.Iterator;

public class SeqArrayListTest {
    public static void main(String[] args) {
        SeqArrayList<Integer> aList = new SeqArrayList<Integer>();
        aList.add(34);
        aList.add(455);
        //int v = aList.get(1);
        Iterator it = aList.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}
