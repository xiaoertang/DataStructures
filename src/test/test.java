package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class test {
    public static void main(String[] args) {
        int n1[] = new int[]{1, 2, 2, 4, 4, 4};
        int n[] = new int[n1.length];
       // HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n1.length; i++){
            n[n1[i]]++;
        }
        int s = 0;
        int idx = 0;
        for(int i=n1.length/2;i<n.length; i++){
            if(n[i]>s){
                s = n[i];
                idx = i;
            }
        }
//        for(int ans:n){
//            System.out.println(ans);
//        }
        System.out.println(idx);

    }

}
