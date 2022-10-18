package com.dsaplayer.system;

// doubly linked list algo
// java does not have a native library for doubly linked lists, only singly
public class DLL {
    class Node {
        Object data;
        Node prev;
        Node next;

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "DLL [Data: "+data+"]";
        }
    }
        
    Node head, tail = null;

    public void addNode(Object data) {
        Node nd = new Node(data);

        if(head == null) {
            head = tail = nd;
        
            head.prev   = null;
            tail.next   = null;
        } else {
            tail.next   = nd;
            nd.prev     = tail;
            tail        = nd;
            tail.next   = null;
        }
    }

    public void dumpList() {
        Node curr = head;
        if(head == null) {
            System.out.println("WARN: Empty DLL!");
            return;
        }

        System.out.println("Nodes of DLL: ");
        while(curr != null) {
            System.out.print(curr.data+" ");
        }

    }
}
