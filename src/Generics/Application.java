package Generics;

import java.util.ArrayList;
import java.util.Map;

public class Application implements Runnable{
    public <T extends Comparable<T>> T max(T a,T b) {
        if (a.compareTo(b)>0) {
            return a;
        }
        return b;
    }

    public void add(LinkedList<? super String> linkedList, String value) {
        System.out.println(value.toLowerCase());
        linkedList.add(value);
    }

    @Override
    public void run() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        //Type Erasure

        stringArrayList.add("First String");
//        stringArrayList.add(100);

        integerArrayList.add(100);
//        integerArrayList.add("Second String");

        LinkedList<String> stringLinkedList = new LinkedList<>();
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        LinkedList<Object> objectLinkedList = new LinkedList<>();

        stringLinkedList.add("First");
        LinkedList.Node<String> second = stringLinkedList.add("Second");
        stringLinkedList.add("Third");
        stringLinkedList.add(second, "Between Second and Third");
//        stringLinkedList.add(100);
        stringLinkedList.print(System.out);

        integerLinkedList.add(10);
        integerLinkedList.add(20);
        integerLinkedList.add(30);
        integerLinkedList.print(System.out);

        objectLinkedList.add(30);
        objectLinkedList.add("30");

//        add(integerLinkedList, 324);

//        integerLinkedList = objectLinkedList;
//        objectLinkedList = integerLinkedList;
//        objectLinkedList.add("sad");

        LinkedList<? super String> arbitraryLinkedList = new LinkedList<>();
//        arbitraryLinkedList = integerLinkedList;
        arbitraryLinkedList = objectLinkedList;
        arbitraryLinkedList = stringLinkedList;
        arbitraryLinkedList.add("Sdsa");

        LinkedList generalLinkedList;
        generalLinkedList = objectLinkedList;
        generalLinkedList = objectLinkedList;
        generalLinkedList = integerLinkedList;
        generalLinkedList.add("324");
        generalLinkedList.add(324);
    }
}
