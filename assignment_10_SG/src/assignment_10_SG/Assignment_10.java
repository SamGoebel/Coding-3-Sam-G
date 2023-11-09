package assignment_10_SG;

import java.util.LinkedList;
import java.math.BigInteger; 
import java.util.Scanner;
import java.util.Collections;
public class Assignment_10 
{
	// Represent a node of the singly linked list
    class Node {
        int data;
        Node next;
 
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
 
    // Represent the head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;
 
    // addNode() will add a new node to the list
    public void addNode(int data)
    {
 
        // Create a new node
        Node newNode = new Node(data);
 
        // Checks if the list is empty
        if (head == null) {
 
            // If list is empty, both head and tail will
            // point to new node
            head = newNode;
            tail = newNode;
        }
        else {
 
            // newNode will be added after tail such that
            // tail's next will point to newNode
            tail.next = newNode;
 
            // newNode will become new tail of the list
            tail = newNode;
        }
    }
 
    // sortList() will sort nodes of the list in ascending
    // order
    public void sortList()
    {
 
        // Node current will point to head
        Node current = head, index = null;
 
        int temp;
 
        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;
 
                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
 
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
 
    // display() will display all the nodes present in the
    // list
    public void display()
    {
        // Node current will point to head
        Node current = head;
 
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            // Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }
 
        System.out.println();
    }
	static void add(LinkedList<BigInteger> list, int option1, int option2) //add method
    {
    	BigInteger e = list.get(option1);
    	BigInteger f = list.get(option2);
  
    BigInteger result = e.add(f);
    System.out.println("The result of the addition was " + result);
    }

   
    
    static void multiply(LinkedList<BigInteger> list, int option1, int option2) //mutiply method
    {
    	BigInteger e = list.get(option1);
    	BigInteger f = list.get(option2);
    	BigInteger result = e.multiply(f);
        System.out.println("The result of the addition was " + result);
    	

    }
   
    static void compare(LinkedList<BigInteger> list, int option1, int option2) //compare method
    {
    	BigInteger e = list.get(option1);
    	BigInteger f = list.get(option2);

    	int result = e.compareTo(f);
   		if(result == 0)
    	{
    	 System.out.println("Both values are equal");
    	 
    	}
   		else
   		if(result == 1)
    	{
    	 System.out.println("List value " + option1 + " is greater than " + option2);
    	 
    	}
   		else
   		if(result == -1)
    	{
    	 System.out.println("List value " + option1 + " is less than " + option2);
    	 
    	}
   		else
   		{
   			System.out.println("Something went wrong");
   		}
    }
    
    
    //Driver to test made methods
    public static void main(String[] args)
    {
    	
    	Scanner myObj = new Scanner(System.in);
    	BigInteger w = new BigInteger("8254628924");
    	BigInteger x = new BigInteger("2222222222");
    	BigInteger y = new BigInteger("2154445222");
    	BigInteger z = new BigInteger("1222772722");
    	
    	int option1 = 0;
    	int option2 = 1;
    	
    	LinkedList<BigInteger> list = new LinkedList<BigInteger>();
    	    
    	 	list.add(w);
    	    list.add(x);
    	    list.add(y);
    	    list.add(z);
    	    System.out.println(list);
    	    System.out.println("Pick a number from 0 to 3 for addition");
    	    option1 = myObj.nextInt();
    	    System.out.println("Pick another number from 0 to 3 for addition");
    	    option2 = myObj.nextInt();
    	    compare(list,option1,option2);
    
    	    System.out.println("Pick a number from 0 to 3 for multiplication");
    	    option1 = myObj.nextInt();
    	    System.out.println("Pick another number from 0 to 3 for multiplication");
    	    option2 = myObj.nextInt();
    	    compare(list,option1,option2);
    
    	    System.out.println("Pick a number from 0 to 3 for comparison");
    	    option1 = myObj.nextInt();
    	    System.out.println("Pick another number from 0 to 3 for comparison");
    	    option2 = myObj.nextInt();
    	    compare(list,option1,option2);
    	    
    	    Collections.sort(list);
    	    System.out.println(list);
	
}
}

