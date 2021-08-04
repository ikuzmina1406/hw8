package ua.GoIT.modul8;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMapEx = new MyHashMap<>();
        myHashMapEx.put(11, "Hello");
        myHashMapEx.put(12, "By");
        myHashMapEx.put(9, "Hello!");
        myHashMapEx.put(7, "By!");
        myHashMapEx.put(3, "By!!!");
        myHashMapEx.print();
        System.out.println("");
        System.out.println(myHashMapEx.get(9));
        System.out.println("");
        myHashMapEx.remove(3);
        myHashMapEx.printSize();
        myHashMapEx.print();
        System.out.println("clear myHashMapEx");
        myHashMapEx.clear();
        myHashMapEx.print();
    }
}
