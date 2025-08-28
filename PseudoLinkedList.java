/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pseudolinkedlist;

/**
 *
 * @author BED
 */
public class PseudoLinkedList {

    private static final int CAPACITY = 100;
    private String[] elements;
    private int size;

    public PseudoLinkedList() {
        elements = new String[CAPACITY];
        size = 0;
    }

    public void add(String value) {
        if (size >= CAPACITY) {
            System.out.println("List is full. Cannot add more elements.");
            return;
        }
        elements[size] = value;
        size++;
        System.out.println("\"" + value + "\" added.");
    }

    public String poll() {
        if (size == 0) {
            System.out.println("List is empty. Nothing to poll.");
            return null;
        }
        String first = elements[0];
        for (int i = 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        elements[size] = null; 
        return first;
    }

    public String peek() {
        if (size == 0) {
            System.out.println("List is empty. Nothing to peek.");
            return null;
        }
        return elements[0];
    }
 
    public String pop() {
        if (size == 0) {
            System.out.println("List is empty. Nothing to pop.");
            return null;
        }
        String last = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return last;
    }

    public void printList() {
        System.out.print("Current List: ");
        if (size == 0) {
            System.out.println("Empty");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]);
            if (i != size - 1) System.out.print(" -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PseudoLinkedList list = new PseudoLinkedList();

        list.add("Song A");
        list.add("Song B");
        list.add("Song C");
        list.printList();

        System.out.println("Peek: " + list.peek());
        System.out.println("Poll: " + list.poll());
        list.printList();

        System.out.println("Pop: " + list.pop());
        list.printList();

        list.add("Song D");
        list.printList();
    }
}
