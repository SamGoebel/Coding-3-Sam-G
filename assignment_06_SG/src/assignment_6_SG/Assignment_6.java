package assignment_6_SG;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Assignment_6 {

	public class SelectionSortDemo {
	
		private static void selectionSort(int[] numbers, int arrSize) {
			long startS = System.nanoTime();
			for (int i = 0; i < numbers.length - 1; i++) {
				// Find index of smallest remaining element
				int indexSmallest = i;
				for (int j = i + 1; j < numbers.length; j++) {
					if (numbers[j] < numbers[indexSmallest]) {
						indexSmallest = j;
					}
				}

				// Swap numbers[i] and numbers[indexSmallest]
				int temp = numbers[i];
				numbers[i] = numbers[indexSmallest];
				numbers[indexSmallest] = temp;
			}
			long finishS = System.nanoTime();
			long timeS = finishS - startS;
			System.out.println(
					"Sorting a random array size of " + arrSize + " took Selecetion Sort " + timeS + " ms to complete");
		}

		static void bubbleSort(int arr[], int arrSize) {
			long startB = System.nanoTime();
			int i, j, temp;
			boolean swapped;
			for (i = 0; i < arrSize - 1; i++) {
				swapped = false;
				for (j = 0; j < arrSize - i - 1; j++) {
					if (arr[j] > arr[j + 1]) {
						// Swap arr[j] and arr[j+1]
						temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
						swapped = true;

					}
				}

				// If no two elements were
				// swapped by inner loop, then break
				if (swapped == false)

					break;
			}
			long finishB = System.nanoTime();
			long timeB = finishB - startB;
			System.out.println(
					"Sorting a random array size of " + arrSize + " took Bubble Sort " + timeB + " ms to complete");
		}

		public static void main(String[] args) {

			Random r = new Random();
			int arrSize = r.nextInt(10000 - 9000);

			//Generates array with numbers between 0 and 100 that is anywhere from 0-1000 values long
			int[] randomIntArray = IntStream.generate(() -> new Random().nextInt(100)).limit(arrSize).toArray();
			int[] randomIntArray2 = randomIntArray;

			// Call the selectionSort method
			selectionSort(randomIntArray, arrSize);
			// System.out.println(Arrays.toString(randomIntArray));
			
			System.out.println(" ");

			// Call the bubbleSort method
			bubbleSort(randomIntArray2, arrSize);
			
			//System.out.println(Arrays.toString(randomIntArray2));
		}
	}

}
