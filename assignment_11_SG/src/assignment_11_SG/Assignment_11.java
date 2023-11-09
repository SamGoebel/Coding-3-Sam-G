package assignment_11_SG;

import java.util.LinkedList;
import java.util.Collections;
public class Assignment_11 
{
	 public static void main(String[] args) {
	        // Create a singly linked list to store the 12 disciples' names.
	        LinkedList<String> disciples = new LinkedList<>();

	        // Add the 12 disciples' names to the linked list.
	        disciples.add("Peter");
	        disciples.add("Andrew");
	        disciples.add("James");
	        disciples.add("John");
	        disciples.add("Philip");
	        disciples.add("Bartholomew");
	        disciples.add("Matthew");
	        disciples.add("Thomas");
	        disciples.add("James");
	        disciples.add("Thaddeus");
	        disciples.add("Simon");
	        disciples.add("Judas Iscariot");

	        // Remove the disciple who betrayed Jesus (Judas Iscariot).
	        disciples.remove("Judas Iscariot");

	        // Sort the disciples' names in alphabetical order.
	        Collections.sort(disciples);

	        // Print the sorted names in reverse order and reverse spelling
	        //Was not sure which one you meant.
	        for (int i = disciples.size() - 1; i >= 0; i--) {
	        	String name = disciples.get(i);
	        	String reverseSpelling = new StringBuilder(name).reverse().toString();
	        	System.out.println(reverseSpelling);
	        }
	    }
	}

