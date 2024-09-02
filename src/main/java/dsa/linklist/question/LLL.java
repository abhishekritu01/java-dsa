package dsa.linklist.question;

import dsa.linklist.singlyll.LL;
import org.w3c.dom.Node;

public class LLL {

    private Node head;
    private Node tail;
    private int size;

    public LLL() {
        this.size = 0;
    }

    // methods create new node
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size = size + 1;
    }

    public void insertLat(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size = size + 1;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLat(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;

        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size = size + 1;

    }

    // insert using recursion
    public void insertRec(int value, int index) {


    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size = size - 1;

        return val;
    }

    public int deleteLast() {
        if (size == 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size = size - 1;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size = size - 1;
        return val;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    // display
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }

        System.out.println("End");
    }


    // this is node
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //1  question remove duplicates
    public void removeDuplicate(){
        Node node = head ;
        while(node.next != null){
            if(node.value== node.next.value){
                node.next = node.next.next;
                size --;
            }else{
                node = node.next;
            }
        }
    }

    public static LLL merge(LLL first , LLL second){
        Node f = first.head;
        Node s = second.head;
        LLL  ans = new LLL();
        while (f !=null && s !=null){
            if(f.value < s.value){
                ans.insertLat(f.value);
                f = f.next;
            }
            else{
                ans.insertLat(s.value);
                s = s.next;
            }
        }
        while(f !=null){
            ans.insertLat(f.value);
            f = f.next;
        }
        while(s !=null){
            ans.insertLat(s.value);
            s = s.next;
        }
        return ans;

    }
}