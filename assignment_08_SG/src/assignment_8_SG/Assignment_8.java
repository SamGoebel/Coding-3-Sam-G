package assignment_8_SG;

import java.util.Random;
import java.util.stream.IntStream;

public class Assignment_8 {
	  
	static void insertionSortInterleaved(int[] randomIntArray, int startIndex, int gap) {
		   for (int i = startIndex + gap; i < randomIntArray.length; i += gap) {
		      int j = i;
		      while (j - gap >= startIndex && randomIntArray[j] < randomIntArray[j - gap]) {
		         // Swap numbers[j] and numbers [j - gap]
		         int temp = randomIntArray[j];
		         randomIntArray[j] = randomIntArray[j - gap];
		         randomIntArray[j - gap] = temp;
		         j -= gap;
		      }
		   }
		  
			 
	}
	
	static void shellSort(int[] randomIntArray, int[] gapValues) {
		
		for (int g = 0; g < gapValues.length; g++) {
		      for (int i = 0; i < gapValues[g]; i++) {
		         insertionSortInterleaved(randomIntArray, i, gapValues[g]);
		      }
		   }
		   
	}
	   
	   private static int partition(int[] randomIntArray2, int startIndex, int endIndex) {
		      // Select the middle value as the pivot.
		      int midpoint = startIndex + (endIndex - startIndex) / 2;
		      int pivot = randomIntArray2[midpoint];
		   
		      // "low" and "high" start at the ends of the array segment
		      // and move towards each other.
		      int low = startIndex;
		      int high = endIndex;
		   
		      boolean done = false;
		      while (!done) {
		         // Increment low while numbers[low] < pivot
		         while (randomIntArray2[low] < pivot) {
		            low = low + 1;
		         }
		      
		         // Decrement high while pivot < numbers[high]
		         while (pivot < randomIntArray2[high]) {
		            high = high - 1;
		         }
		      
		         // If low and high have crossed each other, the loop
		         // is done. If not, the elements are swapped, low is
		         // incremented and high is decremented.
		         if (low >= high) {
		            done = true;
		         }
		         else {
		            int temp = randomIntArray2[low];
		            randomIntArray2[low] = randomIntArray2[high];
		            randomIntArray2[high] = temp;
		            low++;
		            high--;
		         }
		      }

		      // "high" is the last index in the left segment.
		      return high;
		   }
		   
		   private static void quicksort(int[] randomIntArray2, int startIndex, int endIndex) {
			
			   // Only attempt to sort the array segment if there are
		      // at least 2 elements
		      if (endIndex <= startIndex) {
		         return;
		      }
		          
		      // Partition the array segment
		      int high = partition(randomIntArray2, startIndex, endIndex);

		      // Recursively sort the left segment
		      quicksort(randomIntArray2, startIndex, high);

		      // Recursively sort the right segment
		      quicksort(randomIntArray2, high + 1, endIndex);
				
		     
		   }
	  
		 public static void main(String[] args) {
			 
			 for(int x = 1; x < 4; x++)
			 {
			 
			 // Generates array with numbers between 0 and 100 that is anywhere from 0-1000
						// values long
			int[] randomIntArray = IntStream.generate(() -> new Random().nextInt(100)).limit(10000000).toArray();
			int[] randomIntArray2 = randomIntArray;
			int[] gapValues = { 4, 2, 1 };
	     
	      
	      // Display the contents of the array
	      System.out.println("---- Quick Sort Round " + x + " ----");
	      System.out.println(" "); 
	      
	      long startQ = 0;
	      quicksort(randomIntArray2, 0, randomIntArray2.length - 1);
	      long finishQ = System.nanoTime();
		  long timeQ = finishQ - startQ;
		  System.out.println("Sorting a random array size of 10,000,000 took Quick Sort " + timeQ + " ms to complete");
	    
	      
	      System.out.println(" "); 
	      System.out.println("---- Shell Sort Round " + x + " ----");
	        
	      long startS = 0; 
	      shellSort(randomIntArray, gapValues); 
	      long finishS = System.nanoTime();
		  long timeS = finishS - startS;
		  System.out.println("Sorting a random array size of 10,000,000 took Shell Sort " + timeS + " ms to complete");	
		  System.out.println(" "); 
	      
     }	
			 
   }
}