package assignment_14_SG;

import java.util.ArrayList;

class HashTable_Chaining {
    private int size;
    private ArrayList<ArrayList<Integer>> table;

    public HashTable_Chaining(int size) {
        this.size = size;
        this.table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.table.add(new ArrayList<>());
        }
    }

    private int hashFunction(int key) { //division method hash function
        return key % size;
    }

    public void insert(int key, int value) { //setting postions of values and "key"
        int index = hashFunction(key);
        this.table.get(index).add(value);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + this.table.get(i));
        }
    }
}