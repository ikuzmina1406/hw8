package ua.GoIT.modul8;


import java.util.Arrays;

public class MyArrayList <T> {
    private T[] elements ;
    private int countElements = 0;

    public MyArrayList() {

        this.elements = (T[]) new Object[10];
    }

    void add(T element) {
        if (this.elements.length<countElements) {
        grow(countElements +1);
        }
        this.elements[countElements++] = element;
    }
    void grow (int size){

        this.elements = Arrays.copyOf(this.elements, size);
        }
    public void remove(int index){
    System.arraycopy(this.elements, index + 1,this.elements,index,countElements-1-index);
        this.elements[--countElements] = null;
    }
    public void clear(){
    for(int i=0;i<=countElements;i++) {
        this.elements[i] = null;
    }
    }
    public int size(){
      return this.countElements;
    }
    public  T get(int index){
        return this.elements[index];
    }
    public static <O> void print (O element){
     System.out.println(element);
     }

    void print() {
       System.out.println(Arrays.toString(this.elements));
    }

    public static void main(String[] args) {
    MyArrayList<String> MyArrayList = new MyArrayList<>();
    MyArrayList.add("Matvei");
    MyArrayList.add("Yaroslav");
    MyArrayList.add("Alisa");
    MyArrayList.add("Max");
    MyArrayList.add("Lera");
    MyArrayList.add("Polina");
    MyArrayList.print();
    MyArrayList.remove(3);
    MyArrayList.print();
    //MyArrayList.clear();
    //MyArrayList.print();
    MyArrayList.print(MyArrayList.size());
    MyArrayList.print(MyArrayList.get(4));

    MyArrayList<Integer> num = new MyArrayList<>();
    num.add(1);
    num.add(3);
    num.add(5);
    num.print();
    }
}



