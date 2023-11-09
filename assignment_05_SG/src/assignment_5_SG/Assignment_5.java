package assignment_5_SG;

import java.util.*;

public class Assignment_5 {

	public static void main(String[] args) {
		// array being made
		int numbers[] = { 0, 1 };

		int n = numbers.length; // setting n to size of "numbers"
		int x = 0;
		int count = 1;
		System.out.println(Arrays.toString(numbers)); // array before change

		for (int i = 1; i < 15; i++) // loop that makes the array bigger by calling "MakeBigger"
		{

			x = numbers[n - 1] + numbers[n - 2];

			numbers = MakeBigger(n, numbers, x, count); //calls function "MakeBigger'
			n++;
			count++;

		}

		System.out.println(Arrays.toString(numbers)); //prints final result

	}

	public static int[] MakeBigger(int n, int numbers[], int x, int count) {
		int e;

		System.out.println("Count is " + count);

		// create a new array of size n+1
		int newnumbers[] = new int[n + 1];
		// it then inserts the elements from the old array into the new array
		// insert all values till n
		// then insert x at n+1
		for (e = 0; e < n; e++) {
			newnumbers[e] = numbers[e];

			// System.out.println(numbers[e]);
		}

		newnumbers[n] = x;
		// n = newnumbers.length;
		return newnumbers;
	}

}
