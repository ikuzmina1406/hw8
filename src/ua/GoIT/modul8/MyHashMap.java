package ua.GoIT.modul8;

public class MyHashMap<K extends Comparable<K>, V> {
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] values; //= new Node[DEFAULT_CAPACITY];
    private int index;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int valuesLength;
    private float loadFactor;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int length) {
        this(length, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int length, float loadFactor) {

        if (length <= 0) {
            throw new IllegalArgumentException("Длина инициализации должна быть больше 0");
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Коэффициент нагрузки должен быть больше 0");
        }
        this.valuesLength = length;
        this.loadFactor = loadFactor;
        values = new Node[length];
    }

    public V put(K key, V value) {
        int hashCode = hash(key);
        int index = indexForValues(hashCode, valuesLength);
        Node<K, V> node = values[index];
        if (node == null) {
            values[index] = new Node(key, value, hashCode, null);
        } else {
            for (Node<K, V> n = node; n != null; n = n.next) {
                K nodeKey = n.getKey();
                if ((key == null && null == nodeKey) || (key != null && key.equals(nodeKey))) {
                    V oldValue = n.getValue();
                    n.setValue(value);
                    return oldValue;
                }
                if (n.next == null) {
                    n.next = new Node<>(key, value, hashCode, null);
                    break;
                }
            }

        }
        size++;

        return null;
    }

    public V get(K key) {
        int index = indexForValues(hash(key), valuesLength);
        Node<K, V> node = values[index];
        for (Node<K, V> n = node; n != null; n = n.next) {
            if ((key == null && null == n.getKey()) || (key != null && key.equals(n.getKey()))) {
                return n.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int hashCode = hash(key);
        int index = indexForValues(hashCode, valuesLength);
        Node<K, V> node = values[index];
        if (node == null) {
            values[index] = null;
            return null;
        } else {
            for (Node<K, V> n = node; n != null; n = n.next) {
                if ((key == null && null == n.getKey()) || (key != null && key.equals(n.getKey()))) {
                    values[index] = null;
                    size--;
                    return (V) values;
                }
            }
            return null;
        }
        // for (int i = 0; i < size; i++) {
        //    if (values[i] != null) {
        //        if (values[i].getKey().equals(key)) {
        //            values[i] = null;
        //           size--;
        //          condenseValues(i);
        //         break;
        //     }
        // }
        //  }
    }

    public void print() {

        for (int i = 0; i < valuesLength; i++) {
            if (values[i] != null) {
                System.out.println("Key: " + values[i].getKey() + " Value: " + values[i].getValue());

            }
        }

    }

    // private void condenseValues(int start) {
    //  for (int i = start; i < size; i++) {

    //     values[i] = values[i + 1];
    //  }
    //  }

    public void clear() {
        values = new Node[valuesLength];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void printSize() {
        System.out.println("Размер MyHashMap равен " + size);
    }

    class Node<K extends Comparable<K>, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        private final int hashCode;

        public Node(K key, V value, int hashCode, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            this.value = value;
            return value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

    }

    final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private int indexForValues(int hashCode, int valuesLength) {
        int index = (valuesLength - 1) & hashCode;
        return index;

    }
}
