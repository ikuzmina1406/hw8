package ua.GoIT.modul8;

public class MyLinkedListTest {
    public static <E> void main(String[] args) {
        MyLinkedList<Integer> MyLinkedListNum = new MyLinkedList<>();
        MyLinkedListNum.add(1);
        MyLinkedListNum.add(2);
        MyLinkedListNum.add(3);
        //MyLinkedListNum.clear();
        MyLinkedListNum.print();
        MyLinkedList<String> MyLinkedList = new MyLinkedList<>();
        MyLinkedList.add("Hello");
        MyLinkedList.add("World");
        MyLinkedList.add("!");
        MyLinkedList.print();
    }
}