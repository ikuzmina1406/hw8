package ua.GoIT.modul8;

import java.util.Arrays;

public class MyQueue<T> {
    private T[] elements;
    private int size = 0;

    public MyQueue() {
        this.elements = (T[]) new Object[10];
    }

    void add(T element) {
        if (elements.length < size) {
            grow(size + 1);
        }
        elements[size++] = element;
    }

    void grow(int size) {

        elements = Arrays.copyOf(elements, size);
    }

    public void remove(int index) {
        System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        elements[--size] = null;
    }

    public void clear() {
        for (int i = 0; i <= size; i++) {
            elements[i] = null;
        }
    }

    public int size() {
        return this.size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        } else {
            return elements[0];
        }
         }
        // public T peek() {
        //     return elements[0];
        //    }
        //public boolean isEmpty() {
        //    return (T[])elements == null;
        // }
        public static <O > void print (O element){
            System.out.println(element);
        }

        void print () {
            System.out.println(Arrays.toString(elements));
        }


        public static <T > void main (String[]args){
            MyQueue<String> MyQueue = new MyQueue<>();
            MyQueue.add("Simona");
            MyQueue.add("Roma");
            MyQueue.clear();
            MyQueue.print(MyQueue.size());
            MyQueue.print(MyQueue.peek());
            MyQueue.print();

            MyQueue<Integer> MyQueueNum = new MyQueue<>();
            MyQueueNum.add(1);
            MyQueueNum.add(5);
            MyQueueNum.add(7);
            MyQueueNum.add(9);
            MyQueueNum.add(11);
            MyQueueNum.remove(2);
            // MyQueueNum.clear();
            MyQueueNum.print(MyQueueNum.size());
            MyQueueNum.print(MyQueueNum.peek());
            MyQueueNum.print();
        }
    }