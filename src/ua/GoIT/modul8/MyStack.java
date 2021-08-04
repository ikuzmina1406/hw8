package ua.GoIT.modul8;

import java.util.Arrays;

public class MyStack {
    private int size;
    private long[] stackArray;
    private int top;

    public MyStack(int s) {
        size = s;
        stackArray = new long[size];
        top = -1;
    }

    public void push(long j) {
        stackArray[++top] = j;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public void remove(int index) {
        System.arraycopy(stackArray, index + 1, stackArray, index, size - 1 - index);
        stackArray[--size] = 0;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            stackArray[i] = 0;
        }
    }

    public  int size() {
        return this.size;

    }

    public static void main(String[] args) {
        MyStack theStack = new MyStack(10);
        theStack.push(10);
        theStack.push(20);
        theStack.push(30);
        theStack.push(40);
        theStack.push(50);
        //theStack.remove(3);
        //theStack.clear();
       while (!theStack.isEmpty()) {
       long value = theStack.pop();
       System.out.print(value );
        //System.out.print(theStack);
           System.out.print("("+  theStack.size()+")" +" ");
           // System.out.print(theStack.size());
        }
    }
}
         //  System.out.print(value);
         //  System.out.print(" ");
      // }
       // System.out.println("");
   // }
//}