package com.example.designpattern.HashMap;

public class MyHashMap<K, V> {
    private static final int INITIAL_SIZE = 1<<4;
    private static final int MAXIMUM_CAPACITY = 1<<30;

    class Entry<K, V>{
        private K key;
        private V value;
        Entry<K,V> next;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){return key;}
        public V getValue(){return value;}
        public V setValue(V newval){
            value = newval;
            return newval;
        }
        public void setKey(K key) {
            this.key = key;
        }
    }

    Entry<K,V>[] hashTable;

    public MyHashMap(){
        hashTable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity){
        int tableSize = getTableSize(capacity);
        hashTable = new Entry[capacity];
    }

    private int getTableSize(int capacity){
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public void put(K key, V value){
        int hashcode = key.hashCode() & (hashTable.length-1);
        if(hashTable[hashcode]==null){
            hashTable[hashcode] = new Entry<K,V>(key, value);
        }else{
            Entry<K,V> prev = hashTable[hashcode];
            Entry<K,V> node = hashTable[hashcode];
            while(node!=null){
                if(node.key == key){
                    node.setValue(value);
                    return ;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Entry<K,V>(key, value);
        }
    }

    public V get(K key) {

        int hashCode = key.hashCode() & (hashTable.length-1);
        Entry<K,V> node = hashTable[hashCode];

        while(node != null) {
            if(node.key.equals(key)) {
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }

     public static void main(String args[]) {

        MyHashMap<String, String> map = new MyHashMap<>(7);
        map.put("Tharun", "hi");
        // map.put(2, "my");
        // map.put(3, "name");
        // map.put(4, "is");
        // map.put(5, "Tharun");
        // map.put(6, "how");
        // map.put(7, "are");
        // map.put(8, "you");
        // map.put(9, "friends");
        // map.put(10, "?");

        String value = map.get("Tharun");
        System.out.println(value);
    }
}

