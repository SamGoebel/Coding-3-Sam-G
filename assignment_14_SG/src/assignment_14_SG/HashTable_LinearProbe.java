package assignment_14_SG;

class HashTable_LinearProbe {
    private int size;
    private int[] keys;
    private int[] values;

    public HashTable_LinearProbe(int size) { //setting values
        this.size = size;
        this.keys = new int[size];
        this.values = new int[size];
    }

    private int hashFunction(int key) { //division method hash function
        return key % size;
    }

    public void insert(int key, int value) { //setting postions of values and "key"
        int index = hashFunction(key);
        while (keys[index] != 0) {
            index = (index + 1) % size;
        }
        keys[index] = key;
        values[index] = value;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": (" + keys[i] + ", " + values[i] + ")");
        }
    }
}
