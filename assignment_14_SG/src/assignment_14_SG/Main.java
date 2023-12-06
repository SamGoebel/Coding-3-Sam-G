package assignment_14_SG;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HashTable_Chaining chainingTable = new HashTable_Chaining(10); //making the two tables
        HashTable_LinearProbe linearProbeTable = new HashTable_LinearProbe(10);

        Random random = new Random();

        for (int i = 0; i < 20; i++) { 
            int num = random.nextInt(100) + 1; // Generating random numbers between 1 and 100
            chainingTable.insert(num, num);
           }

        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100) + 1; // Generating random numbers between 1 and 100
            int num2 = random.nextInt(100) + 1;
            linearProbeTable.insert(num, num2);
        }

        System.out.println("Chaining Hash Table:"); //displays tables
        chainingTable.display();

        System.out.println("\nLinear Probe Hash Table:");
        linearProbeTable.display();
    }
}