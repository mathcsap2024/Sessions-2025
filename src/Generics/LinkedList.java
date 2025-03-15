package Generics;

import java.io.PrintStream;

public class LinkedList<T> {
    public static class Node<T> {
        protected T data;
        protected Node<T> next;

        public Node(T data) {
            this(data,null);
        }

        public Node(T data, Node<T> next) {
            this.data=data;
            this.next=next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    protected Node<T> start,end;
    protected int size;

    public LinkedList() {
        start=null;
        end=null;
        size=0;
    }

    public Node<T> add(Node<T> previous, T data) {
        Node<T> newNode = new Node<>(data);
        if(previous==null) {
            newNode.setNext(start);
            start=newNode;
        }
        else {
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
        }

        if(previous==end) {
            end=newNode;
        }
        size++;
        return newNode;
    }

    public Node<T> add(T data) {
        Node<T> newNode = new Node<>(data);

        if(end==null) {
            start=newNode;
        }
        else {
            end.setNext(newNode);
        }
        end = newNode;
        size++;

        return newNode;
    }

    public void print(PrintStream printer) {
        Node<T> current=start;
        while(current!=null) {
            printer.print(current.data);
            printer.print(" -> ");
            current=current.next;
        }
        printer.println();
    }
}
